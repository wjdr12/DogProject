package ni.devotion.catfactsapp.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ni.devotion.catfactsapp.retrofit.CatRetrofit
import ni.devotion.catfactsapp.retrofit.NetworkMapper
import ni.devotion.catfactsapp.room.CacheMapper
import ni.devotion.catfactsapp.room.CatDao
import ni.devotion.catfactsapp.utils.DataState

class CatRepository constructor(
    private val catDao: CatDao,
    private val catRetrofit: CatRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getCats(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val catData = catRetrofit.get()
            val catMap = networkMapper.mapFromEntityList(catData)
            for (tempCat in catMap){
                catDao.insert(cacheMapper.mapToEntity(tempCat))
            }
            val cacheCat = catDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}
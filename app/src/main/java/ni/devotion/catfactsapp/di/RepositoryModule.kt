package ni.devotion.catfactsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import ni.devotion.catfactsapp.repository.CatRepository
import ni.devotion.catfactsapp.retrofit.CatRetrofit
import ni.devotion.catfactsapp.retrofit.NetworkMapper
import ni.devotion.catfactsapp.room.CacheMapper
import ni.devotion.catfactsapp.room.CatDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatRepository(
        catDao: CatDao,
        catRetrofit: CatRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): CatRepository {
        return CatRepository(catDao, catRetrofit, cacheMapper, networkMapper)
    }
}
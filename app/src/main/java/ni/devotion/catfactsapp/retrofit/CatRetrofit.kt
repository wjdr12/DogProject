package ni.devotion.catfactsapp.retrofit

import retrofit2.http.GET

interface CatRetrofit {
     @GET("search")
     suspend fun get(): List<CatNetworkEntity>
}
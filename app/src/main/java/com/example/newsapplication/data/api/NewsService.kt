package com.example.newsapplication.data.api


import com.example.newsapplication.models.NewsResponse
import com.example.newsapplication.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//В данном интерфейсе испльзуем коррутины

interface NewsService {
    //аннотация с методом GET в который указываем ссылку на Endpoint
    @GET("/v2/everything")
    suspend fun getEverything(//Данная функция принимает 3 query  параметра
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode: String = "ru",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>
}
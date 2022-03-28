package com.scalioassignment.app.data.remote

import com.scalioassignment.app.data.remote.response.SearchUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {

    @GET("search/photos")
    suspend fun searchUsers(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") numOfPhotos: Int = 10,
    ): ApiResponse<SearchUsersResponse>

    companion object {
        const val BASE_API_URL = "https://api.unsplash.com/"
    }
}
package com.scalioassignment.app.data.repository

import com.scalioassignment.app.data.DataState
import com.scalioassignment.app.model.GithubUserModel
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun searchUsers(query: String, pageNumber: Int, pageSize: Int): Flow<DataState<List<GithubUserModel>>>
}
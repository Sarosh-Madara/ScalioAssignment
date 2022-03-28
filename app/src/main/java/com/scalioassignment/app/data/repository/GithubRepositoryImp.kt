package com.scalioassignment.app.data.repository

import com.scalioassignment.app.data.DataState
import com.scalioassignment.app.data.remote.*
import com.scalioassignment.app.model.GithubUserModel
import com.scalioassignment.app.utils.StringUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GithubRepositoryImp @Inject constructor(
    private val stringUtils: StringUtils,
    private val apiService: GithubApiService
) : GithubRepository{
    override suspend fun searchUsers(
        query: String,
        pageNumber: Int,
        pageSize: Int
    ): Flow<DataState<List<GithubUserModel>>> {
        return flow {
            apiService.searchUsers(query, pageNumber, pageSize).apply {
                this.onSuccessSuspend {
                    data?.let {
                        emit(DataState.success(it.items))
                    }
                }
                // handle the case when the API request gets an error response.
                // e.g. internal server error.
            }.onErrorSuspend {
                emit(DataState.error<List<GithubUserModel>>(message()))

                // handle the case when the API request gets an exception response.
                // e.g. network connection error.
            }.onExceptionSuspend {
                if (this.exception is IOException) {
                    emit(DataState.error<List<GithubUserModel>>(stringUtils.noNetworkErrorMessage()))
                } else {
                    emit(DataState.error<List<GithubUserModel>>(stringUtils.somethingWentWrong()))
                }
            }
        }
    }
}
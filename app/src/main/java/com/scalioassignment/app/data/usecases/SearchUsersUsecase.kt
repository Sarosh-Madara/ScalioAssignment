package com.scalioassignment.app.data.usecases

import com.scalioassignment.app.data.repository.GithubRepository
import com.scalioassignment.app.utils.AppConstants
import javax.inject.Inject

class SearchUsersUsecase @Inject constructor(private val repository: GithubRepository) {
    suspend operator fun invoke(
        query: String,
        pageNum: Int = 1,
        pageSize: Int = AppConstants.API.PHOTOS_PER_PAGE
    ) = repository.searchUsers(
        query = query,
        pageNumber = pageNum,
        pageSize = pageSize
    )
}
package com.scalioassignment.app.data.remote.response

import com.scalioassignment.app.model.GithubUserModel

data class SearchUsersResponse(
    val incomplete_results: Boolean,
    val items: List<GithubUserModel>,
    val total_count: Int
)
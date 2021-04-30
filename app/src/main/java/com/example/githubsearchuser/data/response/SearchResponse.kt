package com.example.githubsearchuser.data.response

import com.example.githubsearchuser.data.model.User

data class SearchResponse (
    var total_count: Int,
    var incomplete_results: Boolean,
    var items: List<User>
)
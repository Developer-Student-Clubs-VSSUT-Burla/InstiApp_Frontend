package com.example.frontend.retrofit

data class Feed(
    val category: String,
    val contributor: Contributor,
    val description: String,
    val feed_image: String,
    val id: Int,
    val team_members: List<TeamMember>,
    val title: String
)


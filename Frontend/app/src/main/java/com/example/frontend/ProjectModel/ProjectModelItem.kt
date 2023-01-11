package com.example.frontend




data class ProjectModelItem(
    val _id: Int,
    val contributor: Contributor,
    val description: String,
    val name: String,
    val tags: String,
    val team_members: List<TeamMember>
)
package com.example.frontend.retrofit

data class Contributor(
    val _id: Int,
    val branch: String,
    val isAdmin: Boolean,
    val name: String,
    val regno: String,
    val username: String
)
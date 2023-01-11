package com.example.frontend.retrofit

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamMember(
    val _id: Int,
    val branch: String,
    val isAdmin: Boolean,
    val name: String,
    val regno: String,
    val username: String
):Parcelable

@Parcelize
class TeamMembers: ArrayList<TeamMember>(),Parcelable
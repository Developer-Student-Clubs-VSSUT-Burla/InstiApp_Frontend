package com.example.frontend

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class ProjectModel : ArrayList<ProjectModelItem>()

data class ProjectModelItem(
    val _id: Int,
    val contributor: Contributor,
    val description: String,
    val link: Any,
    val name: String,
    val post_date: String,
    val tags: String,
    val team_members: List<TeamMember>
)

data class Contributor(
    val _id: Int,
    val branch: Any,
    val isAdmin: Boolean,
    val name: String,
    val regno: String,
    val username: String
)


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
class TeamMembersP : ArrayList<TeamMember>(), Parcelable
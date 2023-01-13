package com.example.frontend

class EventModel : ArrayList<EventModelItem>()

data class EventModelItem(
    val _id: Int,
    val club_name: String,
    val date: String,
    val description: String,
    val expected_no_of_participants: Int,
    val guestdetails: String,
    val name: String,
    val venue: String
)
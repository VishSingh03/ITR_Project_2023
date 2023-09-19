package com.example.internshipproject

data class Hobby(val title:String)

object Supplier {
    val hobbies = listOf<Hobby>(
        Hobby("swimming"),
        Hobby("gaming"),
        Hobby("singing")
                                )
}
package com.kcci.facestagram.repositories

object Repository {
    val accessibleLevel = AccessibleLevelRepository()
    val booking = BookingRepository()
    val category = CategoryRepository()
    val place = PlaceRepository()
    val post = PostRepository()
    val postUser = PostUserRepository()
    val user = UserRepository()
}
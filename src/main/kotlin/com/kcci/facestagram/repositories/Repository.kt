package com.kcci.facestagram.repositories

object Repository {
    val accessibleLevel = AccessibleLevelRepository()
    val booking = BookingRepository()
    val category = CategoryRepository()
    val friend = FriendRepository()
    val place = PlaceRepository()
    val placePrice = PlacePriceRepository()
    val post = PostRepository()
    val postUser = PostUsersRepository()
    val timeTable = TimeTableRepository()
    val user = UserRepository()
}
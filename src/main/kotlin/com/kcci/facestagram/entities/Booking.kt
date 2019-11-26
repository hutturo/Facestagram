package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Booking : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = bookingId

    var bookingId: Int = 0
    var placeId: Int = 0
    var startDate: LocalDateTime = LocalDateTime.now()
    var endDate: LocalDateTime = LocalDateTime.now()
    var price: Int = 0
}
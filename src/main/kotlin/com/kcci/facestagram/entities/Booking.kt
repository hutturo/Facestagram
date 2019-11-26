package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Booking : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = bookingId

    var bookingId: Int = 0
    var placeId: Int = 0
    var startDatetime: LocalDateTime = LocalDateTime.now()
    var endDatetime: LocalDateTime = LocalDateTime.now()

}
package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Booking {
    var bookingId: Int = 0
    var startDate: LocalDateTime = LocalDateTime.now()
    var endDate: LocalDateTime = LocalDateTime.now()
    var price: Int = 0
}
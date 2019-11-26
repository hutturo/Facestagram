package com.kcci.facestagram.entities

import java.time.LocalDateTime

class TimeTable : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = timeTableId

    var timeTableId: Int = 0
    var starttime: LocalDateTime = LocalDateTime.now()
    var endtime: LocalDateTime = LocalDateTime.now()
}
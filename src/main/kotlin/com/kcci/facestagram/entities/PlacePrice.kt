package com.kcci.facestagram.entities

class PlacePrice : DoubleKeyEntity<Int, Int>() {
    override val keyValue1: Int
        get() = placeId
    override val keyValue2: Int
        get() = timeTableId

    var placeId: Int = 0
    var timeTableId: Int = 0
    var price: Int = 0
}
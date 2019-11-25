package com.kcci.facestagram.entities

class Friend : DoubleKeyEntity<Int, Int>() {
    override val keyValue1: Int
        get() = userId
    override val keyValue2: Int
        get() = friendId

    var userId: Int = 0
    var friendId: Int = 0
}
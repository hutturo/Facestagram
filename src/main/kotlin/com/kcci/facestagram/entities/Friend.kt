package com.kcci.facestagram.entities

class Friend : DoubleKeyEntity<Int, Int>() {
    override val keyValue1: Int
        get() = usersId
    override val keyValue2: Int
        get() = friendId

    var usersId: Int = 0
    var friendId: Int = 0
}
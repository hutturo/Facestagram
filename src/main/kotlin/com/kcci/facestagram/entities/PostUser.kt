package com.kcci.facestagram.entities

class PostUsers : DoubleKeyEntity<Int, Int>() {
    override val keyValue1: Int
        get() = postId
    override val keyValue2: Int
        get() = usersId

    var postId: Int = 0
    var usersId: Int = 0
}
package com.kcci.facestagram.entities

class PostUser : DoubleKeyEntity<Int, Int>() {
    override val keyValue1: Int
        get() = postId
    override val keyValue2: Int
        get() = userId
    
    var postId: Int = 0
    var userId: Int = 0
}
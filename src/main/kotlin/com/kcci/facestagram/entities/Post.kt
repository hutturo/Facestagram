package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Post : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = postId

    var postId: Int = 0
    var usersId: Int = 0
    var content: String = ""
    var planStartDate: LocalDateTime = LocalDateTime.now()
    var planEndDate: LocalDateTime? = null
    var postUserId: Int = 0
    var placeId: Int = 0
    var accessibleLevelId: Int = 1
}
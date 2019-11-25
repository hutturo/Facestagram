package com.kcci.facestagram.entities

import java.time.LocalDateTime

class Post {
    var postId: Int = 0
    var userId: Int = 0
    var content: String = ""
    var planStartDate: LocalDateTime = LocalDateTime.now()
    var planEndDate: LocalDateTime? = null
    var postUserId: Int = 0
    var placeId: Int = 0
    var accessibleLevelId: Int = 1
}
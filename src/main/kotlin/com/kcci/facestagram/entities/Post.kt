package com.kcci.facestagram.entities

import org.springframework.web.servlet.mvc.LastModified
import java.time.LocalDateTime

class Post : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = postId

    var postId: Int = 0
    var userId: Int = 0
    var content: String = ""
    var lastModified: LocalDateTime = LocalDateTime.now()
    var planStartDatetime: LocalDateTime? = null
    var planEndDatetime: LocalDateTime? = null
    var placeId: Int = 0
    var accessibleLevelId: Int = 1
}
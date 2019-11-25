package com.kcci.facestagram.entities

class User : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = userId

    var userId: Int = 0
    var friendId: Int = 0
    var email: String = ""
    var profileImage: String = ""
}
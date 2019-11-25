package com.kcci.facestagram.entities

class User : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = userId

    var userId: Int = 0
    var name: String = ""
    var email: String = ""
    var profileImage: String = ""
}
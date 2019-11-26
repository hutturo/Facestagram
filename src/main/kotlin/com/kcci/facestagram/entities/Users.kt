package com.kcci.facestagram.entities

class Users : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = usersId

    var usersId: Int = 0
    var email: String = ""
    var password: String = ""
    var name: String = ""
    var profileImage: ByteArray? = null
}
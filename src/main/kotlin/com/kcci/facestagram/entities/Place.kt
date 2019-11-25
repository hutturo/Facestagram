package com.kcci.facestagram.entities

class Place : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = placeId

    var placeId: Int = 0
    var category: Int = 0
    var name: String = ""
}
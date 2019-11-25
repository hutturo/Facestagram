package com.kcci.facestagram.entities

class Category : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = categoryId

    var categoryId: Int = 0
    var name: String = ""
}
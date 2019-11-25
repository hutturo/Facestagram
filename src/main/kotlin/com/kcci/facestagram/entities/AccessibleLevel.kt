package com.kcci.facestagram.entities

class AccessibleLevel : SingleKeyEntity<Int>() {
    override val keyValue1: Int
        get() = accessibleLevelId

    var accessibleLevelId: Int = 0
    var name: String = ""
}
package com.kcci.facestagram.entities

abstract class DoubleKeyEntity<K1, K2> : SingleKeyEntity<K1>() {
    abstract val keyValue2: K2
}
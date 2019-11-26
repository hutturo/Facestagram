package com.kcci.facestagram.exceptions

class UnupdatableException(val keyCount: Int, message: String) : Exception(message) {

}
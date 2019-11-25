package com.kcci.facestagram.exceptions

import java.lang.Exception

class UnupdatableException(val keyCount: Int, message: String) : Exception(message) {

}
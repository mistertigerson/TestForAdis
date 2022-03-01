package com.example.testforadis

data class Gallery  (
    val photo: String,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}

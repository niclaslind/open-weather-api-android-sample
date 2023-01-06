package com.volvocars.openweathermapandroid.domain.util

fun String.toTitleCase(): String {

    val DELIMITERS = " '-/"

    val sb = StringBuilder()
    var capNext = true

    for (c in toCharArray()) {
        val cc = if (capNext) c.uppercaseChar() else c.lowercaseChar()
        sb.append(cc)
        capNext = DELIMITERS.indexOf(cc.code.toChar()) >= 0
    }
    return sb.toString()
}

fun String.toCityName(): String {
    return this.replace("_", " ").toTitleCase()
}

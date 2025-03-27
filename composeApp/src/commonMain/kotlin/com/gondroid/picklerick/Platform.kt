package com.gondroid.picklerick

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.gondroid.picklerick


expect fun getCurrentTarget(): Target

enum class Target {
    iOS, Android, Desktop
}

fun isDesktop() = getCurrentTarget() == Target.Desktop
fun isAndroid() = getCurrentTarget() == Target.Android
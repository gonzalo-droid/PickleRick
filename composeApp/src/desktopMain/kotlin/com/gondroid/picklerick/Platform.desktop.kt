package com.gondroid.picklerick


class DesktopPlatform : Platform {
    override val name: String = "DesktopPlatform"
}

actual fun getPlatform(): Platform = DesktopPlatform()
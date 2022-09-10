package com.adhiambo.themilkyway.config

open class MilkyWayException(
    private val msg: String = "Unknown error",
    val throwable: Throwable? = null
) : Exception(msg, throwable)
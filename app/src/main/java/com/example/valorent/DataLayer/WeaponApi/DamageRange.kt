package com.example.valorent.DataLayer.WeaponApi

data class DamageRange(
    val bodyDamage: Int,
    val headDamage: Double,
    val legDamage: Double,
    val rangeEndMeters: Int,
    val rangeStartMeters: Int
)
package com.codely.demo.cat

import java.time.LocalDate
import java.util.UUID

data class Cat(
    val id: UUID,
    val name: String,
    val origin: String,
    val vaccinated: Boolean,
    val birthDate: LocalDate,
    val createdAt: LocalDate,
    val stripes: Boolean,
    val eyeColor: EyeColor,
) {
    enum class EyeColor {
        BLUE, GREEN, BROWN, BLACK
    }
    companion object {
        fun vaccinatedWith(
            id: UUID,
            name: String,
            origin: String,
            birthDate: LocalDate,
            createdAt: LocalDate,
            stripes: Boolean,
            eyeColor: EyeColor
        ) = Cat(
            id = id,
            name = name,
            origin = origin,
            vaccinated = true,
            birthDate = birthDate,
            createdAt = createdAt,
            stripes = stripes,
            eyeColor = eyeColor,
        )

        fun notVaccinatedWith(
            id: UUID,
            name: String,
            origin: String,
            birthDate: LocalDate,
            createdAt: LocalDate,
            stripes: Boolean,
            eyeColor: EyeColor,
        ) = Cat(
            id = id,
            name = name,
            origin = origin,
            vaccinated = false,
            birthDate = birthDate,
            createdAt = createdAt,
            stripes = stripes,
            eyeColor = eyeColor,
        )
    }
}

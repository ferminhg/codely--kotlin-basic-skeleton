package com.codely.demo.cat

import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.UUID
import kotlin.test.assertEquals

class CatTest {
    private val id = "92efe4c8-fab9-4cb0-82d9-5c75eeca2dc1"
    private val name = "Mandarina"
    private val origin = "Shelter"
    private val birthDate = "2019-01-01"
    private val fixedDate = LocalDate.of(2021, 8, 31)
    private val stripes = true

    @Test
    fun `should create a vaccinated cat`() {
        val actualCat = Cat.vaccinatedWith(
            id = UUID.fromString(id),
            name = name,
            origin = origin,
            birthDate = LocalDate.parse(birthDate),
            createdAt = fixedDate,
            stripes = stripes,
        )
        val expectedCat = Cat(
            id = UUID.fromString(id),
            name = name,
            origin = origin,
            vaccinated = true,
            birthDate = LocalDate.parse(birthDate),
            createdAt = fixedDate,
            stripes = stripes,
        )

        assertEquals(expectedCat, actualCat)
    }

    @Test
    fun `should create a no vaccinated cat`() {
        val actualCat = Cat.notVaccinatedWith(
            id = UUID.fromString(id),
            name = name,
            origin = origin,
            birthDate = LocalDate.parse(birthDate),
            createdAt = fixedDate,
            stripes = stripes,
        )
        val expectedCat = Cat(
            id = UUID.fromString(id),
            name = name,
            origin = origin,
            vaccinated = false,
            birthDate = LocalDate.parse(birthDate),
            createdAt = fixedDate,
            stripes = stripes,
        )

        assertEquals(expectedCat, actualCat)
    }
}

package com.catenri.hogwartshall.domain

import com.catenri.data.model.Character
import com.catenri.hogwartshall.model.CharacterHouse
import com.catenri.hogwartshall.model.CharacterUiModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class FilterCharactersUseCaseTest {
    private val characterHarry = CharacterUiModel(
        actor = "Daniel Radcliffe",
        alive = true,
        dateOfBirth = "31 07 1980",
        house = CharacterHouse.GRYFFINDOR,
        id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
        image = "https://ik.imagekit.io/hpapi/harry.jpg",
        name = "Harry Potter",
        species = "human",
    )

    private val characterDanielle = CharacterUiModel(
        actor = "Angelina Johnson",
        alive = true,
        dateOfBirth = "date_of_birth 1",
        house = CharacterHouse.SLYTHERIN,
        id = "b634f0a1-7b48-49b6-b039-27f947ee76fd",
        image = "",
        name = "Danielle Tabor",
        species = "human",
    )

    val characters = listOf(characterHarry, characterDanielle)
    val sut by lazy { FilterCharactersUseCase() }

    @Test
    fun `when search query is empty then return all characters`() {
        val result = sut("", characters)
        assertEquals(characters, result)
    }

    @Test
    fun `when search query matches name then return filtered characters`() {
        val result = sut("Harry", characters)
        assertEquals(listOf(characterHarry), result)
    }

    @Test
    fun `when search query matches actor then return filtered characters`() {
        val result = sut("Angelina", characters)
        assertEquals(listOf(characterDanielle), result)
    }

    @Test
    fun `when search query matches actor and name from different characters then return filtered characters`() {
        val result = sut("Daniel", characters)
        assertEquals(characters, result)
    }

    @Test
    fun `when search query doesn't match then return empty list`() {
        val result = sut("xyz", characters)
        assertEquals(emptyList<Character>(), result)
    }
}
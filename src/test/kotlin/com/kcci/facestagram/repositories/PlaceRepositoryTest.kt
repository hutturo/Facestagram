package com.kcci.facestagram.repositories

import com.kcci.facestagram.entities.Place
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class PlaceRepositoryTest {

    @Test
    fun count() {
        assertTrue(Repository.place.count() > 0)
    }

    @Test
    fun getAll() {
        assertTrue(Repository.place.getAll().size > 0)
    }

    @Test
    fun insert() {
        val oldCount = Repository.place.count()
        val testPlace = Place()
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("MM-dd_HH:mm:ss"))
        testPlace.name = "테스트$time"
        testPlace.category = 1

        Repository.place.insert(testPlace)
        assertEquals(oldCount+1, Repository.place.count())
    }

    @Test
    fun update() {
        val testPlaceId = 1
        val time = LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("HH:mm:ss"))
        val place = Repository.place.getByPK(testPlaceId)!!
        val updatedName = place.name + time
        place.name = updatedName
        Repository.place.update(place)

        val updatedUser = Repository.place.getByPK(testPlaceId)!!
        assertEquals(updatedUser.name, updatedName)
    }

    @Test
    fun delete() {
        val lastPlace = Repository.place.getLast()!!
        val oldCount = Repository.place.count()
        Repository.place.delete(lastPlace)

        assertEquals(oldCount-1, Repository.place.count())
    }

    @Test
    fun getLast() {
        val allPlaces = Repository.place.getAll()
        val lastPlace = Repository.place.getLast()!!
        assertEquals(allPlaces[allPlaces.size-1].placeId, lastPlace.placeId)
    }

    @Test
    fun find() {
        assertEquals(Repository.place.find("맥도날드")[0].placeId, 1)
    }

    @Test
    fun getByPK() {
        assertEquals(Repository.place.getByPK(25)?.name, "인앤아웃")
    }

}
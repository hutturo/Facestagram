package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.Booking
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/booking")
class BookingController {

    @GetMapping
    fun getAll() = Repository.booking.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.booking.getByPK(id)

    @PostMapping
    fun insert(@RequestBody booking: Booking){
        Repository.booking.insert(booking)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    fun update(@RequestBody booking: Booking, @PathVariable id: Int){
        val entity = Repository.booking.getByPK(id)
        if (entity == null)
            return

        entity.placeId = booking.placeId
        entity.startDatetime = booking.startDatetime
        entity.endDatetime = booking.endDatetime

        Repository.booking.update(entity)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: Int) = Repository.place.deleteByPK(id)

}
package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.Place
import com.kcci.facestagram.entities.Users
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/place")
class PlaceController {

    @GetMapping
    fun getAll() = Repository.place.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.place.getByPK(id)

    @PostMapping
    fun insert(@RequestBody place: Place){
        Repository.place.insert(place)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    fun update(@RequestBody place: Place, @PathVariable id: Int){
        val entity = Repository.place.getByPK(id)
        if (entity == null)
            return

        entity.category = place.category
        entity.name = place.name
        Repository.place.update(entity)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: Int) = Repository.place.deleteByPK(id)

}
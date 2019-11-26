package com.kcci.facestagram.controllers

import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accessibleLevel")
class AccessibleLevelController {

    @GetMapping
    fun getAll() = Repository.accessibleLevel.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.accessibleLevel.getByPK(id)


}
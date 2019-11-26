package com.kcci.facestagram.controllers

import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController {

    @GetMapping
    fun getAll() = Repository.category.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.category.getByPK(id)
}
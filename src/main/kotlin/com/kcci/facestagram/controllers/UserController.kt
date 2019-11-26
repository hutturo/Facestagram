package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.User
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {
    @GetMapping
    fun getAll() = Repository.user.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.user.getByPK(id)

    @PostMapping
    fun insert(@RequestBody user: User){
        Repository.user.insert(user)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    fun update(@RequestBody user: User, @PathVariable id: Int){
        val entity = Repository.user.getByPK(id)
        if (entity == null)
            return

        entity.email = user.email
        entity.password = user.password
        entity.name = user.name
        entity.profileImage = user.profileImage
        Repository.user.update(entity)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: Int) = Repository.user.deleteByPK(id)
}
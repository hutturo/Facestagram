package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.Users
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {


    @GetMapping
    fun getAll() = Repository.users.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.users.getByPK(id)

    @PostMapping
    fun insert(@RequestBody user: Users){
        Repository.users.insert(user)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    fun update(@RequestBody user: Users, @PathVariable id: Int){
        val entity = Repository.users.getByPK(id)
        if (entity == null)
            return

        entity.email = user.email
        entity.password = user.password
        entity.name = user.name
        entity.profileImage = user.profileImage
        Repository.users.update(entity)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: Int) = Repository.users.deleteByPK(id)


}
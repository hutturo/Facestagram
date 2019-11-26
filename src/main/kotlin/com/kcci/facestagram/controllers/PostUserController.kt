package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.PostUser
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postUser")
class PostUserController {

    @GetMapping
    fun getAll() = Repository.postUser.getAll()

    @PostMapping
    fun insert(@RequestBody postUser: PostUser){
        Repository.postUser.insert(postUser)
    }


   // @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    //fun deleteByPK(@PathVariable id: Int)

}
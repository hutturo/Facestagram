package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.Post
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController {

    @GetMapping
    fun getAll() = Repository.post.getAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int) = Repository.post.getByPK(id)

    @PostMapping
    fun insert(@RequestBody post: Post){
        println(post)
        Repository.post.insert(post)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    fun update(@RequestBody post: Post, @PathVariable id: Int){
        val entity = Repository.post.getByPK(id)
        if (entity == null)
            return

        entity.userId = post.userId
        entity.content = post.content
        entity.lastModified = post.lastModified
        entity.planStartDatetime = post.planStartDatetime
        entity.planEndDatetime = post.planEndDatetime
        entity.placeId = post.placeId
        entity.accessibleLevelId = post.accessibleLevelId

        Repository.post.update(entity)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: Int) = Repository.post.deleteByPK(id)
}
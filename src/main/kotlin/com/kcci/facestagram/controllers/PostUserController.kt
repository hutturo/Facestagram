package com.kcci.facestagram.controllers

import com.kcci.facestagram.entities.PostUsers
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/postUser")
class PostUserController {

    @GetMapping
    fun getAll() = Repository.postUser.getAll()

    // @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    //fun getById(@PathVariable id: Int) = Repository.friend.getByPK(id)

    //@RequestMapping(path = ["/{id}","/{id2}"], method = [RequestMethod.GET])
    @RequestMapping(path = ["/friend/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int, @PathVariable id2: Int) = Repository.friend.getByPK(id, id2)
//    {
//        var numbersContainer: List<String> = id.split(",")
//        Repository.postUser.getByPK( Integer.parseInt(numbersContainer[0]),
//                Integer.parseInt(numbersContainer[1]))
//    }

    @PostMapping
    fun insert(@RequestBody postUser: PostUsers){
        Repository.postUser.insert(postUser)
    }

//    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
//    fun deleteByPK(@PathVariable id: Int) = Repository.friend.deleteByPK(id)

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable id: String)  {
        var numbersContainer: List<String> = id.split(",")
        Repository.postUser.deleteByPK(Integer.parseInt(numbersContainer[0]),
                Integer.parseInt(numbersContainer[1]))
    }

}
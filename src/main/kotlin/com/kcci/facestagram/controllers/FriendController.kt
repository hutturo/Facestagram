package com.kcci.facestagram.controllers


import com.kcci.facestagram.entities.Friend
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friend")
class FriendController {

    @GetMapping
    fun getAll() = Repository.friend.getAll()

   // @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    //fun getById(@PathVariable id: Int) = Repository.friend.getByPK(id)

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable doubleKeyId: String) {
        var numbersContainer: List<String> = doubleKeyId.split(",")
        Repository.friend.getByPK( Integer.parseInt(numbersContainer[0]),
                Integer.parseInt(numbersContainer[1]))
    }

    @PostMapping
    fun insert(@RequestBody friend: Friend){
        Repository.friend.insert(friend)
    }


//    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
//    fun deleteByPK(@PathVariable id: Int) = Repository.friend.deleteByPK(id)

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteByPK(@PathVariable doubleKeyId: String)  {
        var numbersContainer: List<String> = doubleKeyId.split(",")
        Repository.friend.deleteByPK(Integer.parseInt(numbersContainer[0]),
                Integer.parseInt(numbersContainer[1]))
    }

}
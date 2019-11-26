package com.kcci.facestagram.controllers


import com.kcci.facestagram.entities.Friend
import com.kcci.facestagram.repositories.Repository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friend")
class FriendController {

    @GetMapping
    fun getAll() = Repository.friend.getAll()



    /*
    /@RequestMapping(path = ["/{id}","/{id2}"], method = [RequestMethod.GET])
    @RequestMapping(path = ["/friend/{id}/{id2}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Int, @PathVariable id2: Int) = Repository.friend.getByPK(id, id2)
//    {
//        var numbersContainer: List<String> = id.split(",")
//        Repository.postUser.getByPK( Integer.parseInt(numbersContainer[0]),
//                Integer.parseInt(numbersContainer[1]))
//    }
     */
    // @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    //fun getById(@PathVariable id: Int) = Repository.friend.getByPK(id)
//
//    @RequestMapping(path = ["/friend/{id}/{id2}"], method = [RequestMethod.GET])
//    fun getById(@PathVariable id: Int, @PathVariable id2: Int) = Repository.friend.getByPK(id, id2)

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
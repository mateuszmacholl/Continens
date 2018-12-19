package mateuszmacholl.continens.user.controller

import mateuszmacholl.continens.user.model.User
import mateuszmacholl.continens.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/users"])
class UserController(private val userService: UserService) {
    @RequestMapping(value = [""], method = [RequestMethod.GET])
    fun getAll(): ResponseEntity<*>{
        val users = userService.findAll()
        return ResponseEntity(users, HttpStatus.OK)
    }
    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable(value = "id") id: String): ResponseEntity<*>{
        val user = userService.findById(id)
        return ResponseEntity(user, HttpStatus.OK)
    }
    @RequestMapping(value = [""], method = [RequestMethod.POST])
    fun save(@RequestBody user: User): ResponseEntity<*>{
        val savedUser = userService.save(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }
    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable(value = "id") id: String): ResponseEntity<*>{
        userService.delete(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }
}
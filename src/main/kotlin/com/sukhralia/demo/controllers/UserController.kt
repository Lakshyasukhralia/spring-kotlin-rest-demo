package com.sukhralia.demo.controllers

import com.sukhralia.demo.models.User
import com.sukhralia.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/")
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): User {
        return userService.getUser(id)
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: User): User {
        return userService.createUser(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User): User {
        return userService.updateUser(id, user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): String {
        return userService.deleteUser(id)
    }
}
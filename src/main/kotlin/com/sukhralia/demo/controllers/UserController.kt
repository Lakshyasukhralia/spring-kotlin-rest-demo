package com.sukhralia.demo.controllers

import com.sukhralia.demo.models.User
import com.sukhralia.demo.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userRepository.findAll())
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<User> {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null))
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userRepository.save(user))
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User): ResponseEntity<User> {
        val oldUser = userRepository.findById(id).orElse(null)
        oldUser.name = user.name
        oldUser.email = user.email
        oldUser.password = user.password
        return ResponseEntity.ok(userRepository.save(oldUser))
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
        userRepository.deleteById(id)
        return ResponseEntity.ok(id)
    }
}
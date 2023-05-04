package com.sukhralia.demo.service

import com.sukhralia.demo.errors.UserNotFoundException
import com.sukhralia.demo.models.User
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl : UserService {

    private val userList = mutableListOf<User>()

    override fun getUsers(): List<User> {
        return userList
    }

    override fun getUser(id: String): User {
        return userList.find { it.id == id } ?: throw UserNotFoundException("User with id = $id not found")
    }

    override fun createUser(user: User): User {
        user.id = UUID.randomUUID().toString()
        userList.add(user)
        return user
    }

    override fun updateUser(id: String, user: User): User {
        userList.find { it.id == id }?.let {
            it.name = user.name
            it.email = user.email
        }
        return user
    }

    override fun deleteUser(id: String): String {
        val done = userList.removeIf { it.id == id }
        if (done) return id else throw RuntimeException("User with id = $id not found")
    }
}
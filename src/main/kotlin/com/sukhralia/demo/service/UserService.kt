package com.sukhralia.demo.service

import com.sukhralia.demo.models.User

interface UserService {
    fun getUsers(): List<User>
    fun getUser(id: String): User
    fun createUser(user: User): User
    fun updateUser(id: String, user: User): User
    fun deleteUser(id: String): String
}
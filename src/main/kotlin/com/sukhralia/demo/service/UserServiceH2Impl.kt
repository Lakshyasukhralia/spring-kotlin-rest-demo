package com.sukhralia.demo.service

import com.sukhralia.demo.mapper.toEntity
import com.sukhralia.demo.mapper.toUser
import com.sukhralia.demo.models.User
import com.sukhralia.demo.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceH2Impl(private val userRepository: UserRepository) : UserService {
    override fun getUsers(): List<User> {
        return userRepository.findAll().map { it.toUser() }
    }

    override fun getUser(id: String): User {
        val user = userRepository.findById(id).get()
        return user.toUser()
    }

    override fun createUser(user: User): User {
        user.id = UUID.randomUUID().toString()
        userRepository.save(user.toEntity())
        return user
    }

    override fun updateUser(id: String, user: User): User {
        val userEntity = userRepository.findById(id).get()
        userEntity.apply {
            name = user.name
            email = user.email
        }
        return userRepository.save(userEntity).toUser()
    }

    override fun deleteUser(id: String): String {
        userRepository.deleteById(id)
        return id
    }
}
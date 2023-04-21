package com.sukhralia.demo.repositories

import com.sukhralia.demo.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>
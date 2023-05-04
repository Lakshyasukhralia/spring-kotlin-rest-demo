package com.sukhralia.demo.mapper

import com.sukhralia.demo.entity.UserEntity
import com.sukhralia.demo.models.User

fun UserEntity.toUser(): User {
    return User(id, name, email)
}

fun User.toEntity(): UserEntity {
    return UserEntity(id, name, email)
}
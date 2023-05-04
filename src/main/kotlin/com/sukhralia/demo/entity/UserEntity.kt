package com.sukhralia.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_user")
data class UserEntity(
    @Id
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
)

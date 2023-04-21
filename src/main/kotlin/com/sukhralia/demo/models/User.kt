package com.sukhralia.demo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null
)

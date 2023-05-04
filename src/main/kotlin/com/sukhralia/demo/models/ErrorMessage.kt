package com.sukhralia.demo.models

import org.springframework.http.HttpStatus

data class ErrorMessage(val status: HttpStatus, val message: String)
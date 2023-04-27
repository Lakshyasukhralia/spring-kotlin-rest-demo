package com.sukhralia.demo.models

import org.springframework.http.HttpStatus

data class ErrorMessage(val statusCode: HttpStatus, val message: String)
package com.sukhralia.demo.errors

import com.sukhralia.demo.models.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun userNotFoundExceptionHandler(exception: Exception): ErrorMessage {
        return ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.message ?: "Something went wrong")
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun userNotFoundExceptionHandler(userNotFoundException: UserNotFoundException): ErrorMessage {
        return ErrorMessage(HttpStatus.NOT_FOUND, userNotFoundException.message ?: "Something went wrong")
    }
}
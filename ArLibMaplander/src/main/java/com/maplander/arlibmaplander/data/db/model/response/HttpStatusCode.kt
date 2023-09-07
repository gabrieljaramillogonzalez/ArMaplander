package com.maplander.arlibmaplander.data.db.model.response

class HttpStatusCode {
    companion object{
        val OK = 200
        val NO_CONTENT = 204
        val BAD_REQUEST = 400
        val FORBIDDEN = 403
        val ALREADY_EXISTS = 470
        val NOT_EXISTS = 471
        val INCORRECT_PASS = 472
        val INTERNAL_SERVER_ERROR = 500
    }
}
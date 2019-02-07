package com.course.clean.core.base

import okhttp3.ResponseBody

interface NetworkErrorHandler {
    fun onHttpError(errorBody: ResponseBody?, code: Int)
    fun onTimeout()
    fun onNetworkError()
    fun onUnknownError(message: String?)
}


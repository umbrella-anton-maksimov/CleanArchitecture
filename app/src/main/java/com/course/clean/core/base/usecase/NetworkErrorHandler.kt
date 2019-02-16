package com.course.clean.core.base.usecase

import okhttp3.ResponseBody

interface NetworkErrorHandler {
    fun onHttpError(errorBody: ResponseBody?, code: Int)
    fun onTimeout()
    fun onNetworkError()
    fun onUnknownError(message: String?)
}


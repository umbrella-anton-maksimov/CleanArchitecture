package com.course.clean.core.base.usecase

import io.reactivex.subscribers.DisposableSubscriber
import retrofit2.HttpException
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.SocketTimeoutException

abstract class UseCaseSubscriber<T>(handler: NetworkErrorHandler? = null) : DisposableSubscriber<T>() {
    private val handler = WeakReference(handler)

    override fun onError(e: Throwable) {
        val handler = handler.get()
        when (e) {
            is HttpException -> {
                val responseBody = e.response().errorBody()
                handler?.onHttpError(responseBody, e.code())
            }
            is SocketTimeoutException -> handler?.onTimeout()
            is IOException -> handler?.onNetworkError()
            else -> handler?.onUnknownError(e.message)
        }
        onComplete()
    }

    override fun onComplete() = Unit

    abstract override fun onNext(data: T?)
}

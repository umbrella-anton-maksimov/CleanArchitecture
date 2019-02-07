package com.course.clean.core.base

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class UseCase<T, in Params> {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected abstract fun createWith(params: Params? = null): Flowable<T>

    fun execute(subscriber: DisposableSubscriber<T>, params: Params? = null) {
        val flowable = this.createWith(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        flowable.subscribeWith(subscriber).addTo(compositeDisposable)
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) compositeDisposable.clear()
    }

}





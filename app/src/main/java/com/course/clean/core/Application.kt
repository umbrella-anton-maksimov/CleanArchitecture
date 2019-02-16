package com.course.clean.core

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.course.clean.core.di.ApplicationComponent
import com.course.clean.core.di.ApplicationModule
import com.course.clean.core.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by antonmaksimov on 1/31/19.
 * anton.maksimov@umbrella-web.com
 */

class Application : Application(), HasActivityInjector, HasSupportFragmentInjector {

    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
        @Inject set

    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null
        @Inject set


    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

}
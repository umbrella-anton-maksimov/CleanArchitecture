package com.course.clean.core.di

import com.course.clean.core.Application
import com.course.clean.repository.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */


@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: Application)
}
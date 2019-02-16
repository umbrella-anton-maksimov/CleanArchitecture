package com.course.clean.core.di

import androidx.lifecycle.ViewModelProvider
import com.course.clean.core.base.viewmodel.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
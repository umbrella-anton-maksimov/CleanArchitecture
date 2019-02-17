package com.course.clean.view.movie.flow.di

import com.course.clean.view.movie.flow.MoviesActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MoviesActivityModule::class])
interface MoviesActivityComponent : AndroidInjector<MoviesActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesActivity>()

}
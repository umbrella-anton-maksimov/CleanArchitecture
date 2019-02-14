package com.course.clean.view.movie.di

import com.course.clean.view.movie.MoviesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MoviesFragmentModule::class])
interface MoviesFragmentComponent : AndroidInjector<MoviesFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesFragment>()
}


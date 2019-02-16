package com.course.clean.view.movie.di

import com.course.clean.view.movie.MovieDetailsFragment
import com.course.clean.view.movie.MoviesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MovieDetailsFragmentModule::class])
interface MovieDetailsFragmentComponent : AndroidInjector<MovieDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsFragment>()
}


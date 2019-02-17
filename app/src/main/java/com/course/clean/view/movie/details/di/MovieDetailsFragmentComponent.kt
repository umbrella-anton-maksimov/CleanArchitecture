package com.course.clean.view.movie.details.di

import com.course.clean.view.movie.details.MovieDetailsFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MovieDetailsFragmentModule::class])
interface MovieDetailsFragmentComponent : AndroidInjector<MovieDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsFragment>()
}


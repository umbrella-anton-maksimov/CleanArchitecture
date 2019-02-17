package com.course.clean.view.movie.list.di

import com.course.clean.view.movie.list.MovieListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MovieListFragmentModule::class])
interface MovieListFragmentComponent : AndroidInjector<MovieListFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieListFragment>()
}


package com.course.clean.view.movie.list.di

import com.course.clean.usecase.movies.FetchMoviesUseCase
import com.course.clean.view.movie.details.MovieDetailsFragment
import com.course.clean.view.movie.details.MovieDetailsView
import com.course.clean.view.movie.flow.MoviesActivity
import com.course.clean.view.movie.flow.MoviesFlow
import com.course.clean.view.movie.list.*
import dagger.Module
import dagger.Provides

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class MovieListFragmentModule {

    @Provides
    fun provideView(fragment: MovieListFragment): MovieListView = fragment

    @Provides
    fun providePresenter(
        view: MovieListView,
        fetchMoviesUseCase: FetchMoviesUseCase
    ): MovieListPresenter {
        return MovieListPresenter(view, fetchMoviesUseCase)
    }
}
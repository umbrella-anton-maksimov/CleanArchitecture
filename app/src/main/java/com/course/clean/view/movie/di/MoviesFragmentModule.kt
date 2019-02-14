package com.course.clean.view.movie.di

import com.course.clean.usecase.movies.FetchMoviesUseCase
import com.course.clean.viewmodel.MovieListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class MoviesFragmentModule {

    @Provides
    fun provideViewModel(fetchMoviesUseCase: FetchMoviesUseCase) = MovieListViewModel(fetchMoviesUseCase)
}
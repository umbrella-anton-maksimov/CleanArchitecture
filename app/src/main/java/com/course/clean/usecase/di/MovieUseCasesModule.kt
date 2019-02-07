package com.course.clean.usecase.di

import com.course.clean.repository.MoviesRepository
import com.course.clean.usecase.movies.FetchMoviesUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by antonmaksimov on 1/31/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class MovieUseCasesModule {

    @Provides
    fun provideFetchMoviesUseCase(repository: MoviesRepository) = FetchMoviesUseCase(repository)

}
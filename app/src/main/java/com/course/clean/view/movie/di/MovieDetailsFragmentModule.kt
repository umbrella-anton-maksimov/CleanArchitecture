package com.course.clean.view.movie.di

import androidx.lifecycle.ViewModel
import com.course.clean.core.di.ViewModelKey
import com.course.clean.usecase.movies.FetchMoviesUseCase
import com.course.clean.viewmodel.MovieListViewModel
import com.course.clean.viewmodel.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
abstract class MovieDetailsFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindViewModel(viewModel: MovieViewModel): ViewModel
}
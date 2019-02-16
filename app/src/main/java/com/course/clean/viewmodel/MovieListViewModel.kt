package com.course.clean.viewmodel

import androidx.lifecycle.ViewModel
import com.course.clean.core.base.usecase.UseCaseSubscriber
import com.course.clean.entity.Movie
import com.course.clean.usecase.movies.FetchMoviesUseCase
import com.course.clean.view.adapter.MoviesAdapter

/**
 * Created by antonmaksimov on 1/30/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieListViewModel(private val fetchMoviesUseCase: FetchMoviesUseCase){

    val adapter = MoviesAdapter()

    fun fetchMovies() {
        fetchMoviesUseCase.execute(FetchMoviesSubscriber())
    }

    fun onDestroy() {
        fetchMoviesUseCase.dispose()
    }

    private inner class FetchMoviesSubscriber : UseCaseSubscriber<List<Movie>>() {
        override fun onNext(data: List<Movie>?) {
            data?.let {
                adapter.updateContent(it)
            }
        }
    }
}
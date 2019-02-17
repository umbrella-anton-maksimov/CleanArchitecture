package com.course.clean.view.movie.list

import com.course.clean.core.base.usecase.UseCaseSubscriber
import com.course.clean.entity.Movie
import com.course.clean.usecase.movies.FetchMoviesUseCase
import com.course.clean.view.movie.flow.MoviesFlow
import javax.inject.Inject

/**
 * Created by antonmaksimov on 1/30/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieListPresenter @Inject constructor(
    private val view: MovieListView,
    private val fetchMoviesUseCase: FetchMoviesUseCase
) {

     var flow: MoviesFlow?=null

    fun fetchMovies() {
        fetchMoviesUseCase.execute(FetchMoviesSubscriber())
    }

    fun onDestroy() {
        fetchMoviesUseCase.dispose()
    }

    fun onItemClick(movie: Movie) = flow?.openMovieDetails(movie)

    private inner class FetchMoviesSubscriber : UseCaseSubscriber<List<Movie>>() {
        override fun onNext(data: List<Movie>?) {
            data?.let {
                view.updateContent(it)
            }
        }
    }
}
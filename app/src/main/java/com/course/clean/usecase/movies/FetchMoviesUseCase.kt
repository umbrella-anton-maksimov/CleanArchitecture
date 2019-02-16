package com.course.clean.usecase.movies

import com.course.clean.core.base.usecase.UseCase
import com.course.clean.entity.Movie
import com.course.clean.repository.MoviesRepository
import com.course.clean.usecase.movies.FetchMoviesUseCase.Params
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

class FetchMoviesUseCase
@Inject constructor(private val repository: MoviesRepository) : UseCase<List<Movie>, Params>() {

    override fun createWith(params: Params?): Flowable<List<Movie>> = repository.fetchMovie().toFlowable()

    data class Params(val year: String)
}
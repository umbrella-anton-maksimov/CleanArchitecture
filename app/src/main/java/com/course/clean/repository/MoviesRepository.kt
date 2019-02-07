package com.course.clean.repository

import com.course.clean.entity.Movie
import io.reactivex.Single

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

interface MoviesService {
    fun fetchMovies(): Single<List<Movie>>
}

class MoviesRepository(private val service: MoviesService) {

    fun fetchMovie() = service.fetchMovies()

}
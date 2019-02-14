package com.course.clean.view.movie

import com.course.clean.entity.Movie

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

interface MoviesActivityFlow {
    fun back()
    fun openMovieDetails(movie: Movie)
}


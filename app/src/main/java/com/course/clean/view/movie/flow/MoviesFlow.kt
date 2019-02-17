package com.course.clean.view.movie.flow

import com.course.clean.entity.Movie

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

interface MoviesFlow {
    fun back()
    fun openMovieDetails(movie: Movie)
}


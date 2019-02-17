package com.course.clean.view.movie.details

import com.course.clean.entity.Movie

/**
 * Created by antonmaksimov on 2/17/19.
 * anton.maksimov@umbrella-web.com
 */

interface MovieDetailsView {
    fun updateContent(movie: Movie)
}
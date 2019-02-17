package com.course.clean.view.movie.details

import com.course.clean.entity.Movie

/**
 * Created by antonmaksimov on 2/17/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieDetailsPresenter(private val view: MovieDetailsView) {

    var movie: Movie? = null
        set(value) {
            field = value
            view.updateContent(value ?: return)
        }

}
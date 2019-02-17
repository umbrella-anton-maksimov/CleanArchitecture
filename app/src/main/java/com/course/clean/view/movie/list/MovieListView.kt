package com.course.clean.view.movie.list

import com.course.clean.entity.Movie

/**
 * Created by antonmaksimov on 2/17/19.
 * anton.maksimov@umbrella-web.com
 */

interface MovieListView {
    fun updateContent(movies: List<Movie>)

}
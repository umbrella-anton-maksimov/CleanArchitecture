package com.course.clean.viewmodel

import androidx.lifecycle.*
import com.course.clean.entity.Movie
import javax.inject.Inject

/**
 * Created by antonmaksimov on 2/16/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieViewModel @Inject constructor() : ViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun init(movie: Movie?) {
        this._movie.postValue(movie)
    }

}
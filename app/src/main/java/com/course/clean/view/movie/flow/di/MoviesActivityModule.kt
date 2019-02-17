package com.course.clean.view.movie.flow.di

import com.course.clean.view.movie.flow.MoviesActivity
import com.course.clean.view.movie.flow.MoviesFlow
import dagger.Module
import dagger.Provides


/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class MoviesActivityModule {

    @Provides
    fun provideFlow(activity: MoviesActivity): MoviesFlow = activity

}
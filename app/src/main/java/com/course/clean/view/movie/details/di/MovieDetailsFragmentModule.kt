package com.course.clean.view.movie.details.di

import com.course.clean.view.movie.details.*
import dagger.Module
import dagger.Provides

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class MovieDetailsFragmentModule {

    @Provides
    fun provideView(fragment: MovieDetailsFragment): MovieDetailsView = fragment

    @Provides
    fun providePresenter(view: MovieDetailsView) = MovieDetailsPresenter(view)

}
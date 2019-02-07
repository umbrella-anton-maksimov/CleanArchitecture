package com.course.clean.core.di

import android.app.Activity
import com.course.clean.view.movie.MoviesActivity
import com.course.clean.view.movie.di.MoviesActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


/**
 * Created by antonmaksimov on 11/11/18.
 * anton.maksimov@umbrella-web.com
 */

@Module(subcomponents = [MoviesActivityComponent::class])
abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MoviesActivity::class)
    internal abstract fun bindMoviesActivity(
            builder: MoviesActivityComponent.Builder
    ): AndroidInjector.Factory<out Activity>

}
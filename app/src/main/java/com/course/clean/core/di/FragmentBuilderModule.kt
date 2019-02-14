package com.course.clean.core.di

import android.support.v4.app.Fragment
import com.course.clean.view.movie.MoviesFragment
import com.course.clean.view.movie.di.MoviesFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


/**
 * Created by antonmaksimov on 11/11/18.
 * anton.maksimov@umbrella-web.com
 */

@Module(subcomponents = [MoviesFragmentComponent::class])
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(MoviesFragment::class)
    internal abstract fun bindMoviesFragment(
        builder: MoviesFragmentComponent.Builder
    ): AndroidInjector.Factory<out Fragment>

}
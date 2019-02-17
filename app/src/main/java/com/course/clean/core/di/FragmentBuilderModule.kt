package com.course.clean.core.di

import androidx.fragment.app.Fragment
import com.course.clean.view.movie.details.MovieDetailsFragment
import com.course.clean.view.movie.details.di.MovieDetailsFragmentComponent
import com.course.clean.view.movie.list.MovieListFragment
import com.course.clean.view.movie.list.di.MovieListFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


/**
 * Created by antonmaksimov on 11/11/18.
 * anton.maksimov@umbrella-web.com
 */

@Module(
    subcomponents = [
        MovieListFragmentComponent::class,
        MovieDetailsFragmentComponent::class
    ]
)
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(MovieListFragment::class)
    internal abstract fun bindMoviesFragment(
        builder: MovieListFragmentComponent.Builder
    ): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(MovieDetailsFragment::class)
    internal abstract fun bindMovieDetailsFragment(
        builder: MovieDetailsFragmentComponent.Builder
    ): AndroidInjector.Factory<out Fragment>

}
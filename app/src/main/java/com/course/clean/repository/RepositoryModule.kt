package com.course.clean.repository

import dagger.Module
import dagger.Provides

/**
 * Created by antonmaksimov on 1/31/19.
 * anton.maksimov@umbrella-web.com
 */

@Module(includes = [RestServiceModule::class])
class RepositoryModule {

    @Provides
    fun provideMoviesRepository(service: MoviesService) = MoviesRepository(service)

}
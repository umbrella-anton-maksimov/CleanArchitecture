package com.course.clean.repository

import com.course.clean.entity.Movie
import dagger.Module
import dagger.Provides
import io.reactivex.Single

/**
 * Created by antonmaksimov on 1/31/19.
 * anton.maksimov@umbrella-web.com
 */

@Module
class RestServiceModule {

    @Provides
    fun provideMoviesService() = object : MoviesService {
        override fun fetchMovies(): Single<List<Movie>> {
            return Single.just(
                listOf(
                    Movie(1, "Pirates of the Caribbean: The Curse of the Black Pearl", "2003"),
                    Movie(2, "Pirates of the Caribbean: Dead Man's Chest", "2006"),
                    Movie(3, "Pirates of the Caribbean: At World's End", "2007"),
                    Movie(4, "Pirates of the Caribbean: On Stranger Tides", "2011"),
                    Movie(5, "Pirates of the Caribbean: Dead Men Tell No Tales", "2017")
                )
            )
        }
    }

}
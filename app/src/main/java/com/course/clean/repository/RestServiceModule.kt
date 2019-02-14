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
                            Movie(
                                    1,
                                    "Pirates of the Caribbean: The Curse of the Black Pearl",
                                    "2003",
                                    "https://upload.wikimedia.org/wikipedia/en/8/89/Pirates_of_the_Caribbean_-_The_Curse_of_the_Black_Pearl.png"
                            ),
                            Movie(
                                    2,
                                    "Pirates of the Caribbean: Dead Man's Chest",
                                    "2006",
                                    "https://upload.wikimedia.org/wikipedia/en/thumb/2/2d/Pirates_of_the_caribbean_2_poster_b.jpg/220px-Pirates_of_the_caribbean_2_poster_b.jpg"
                            ),
                            Movie(
                                    3,
                                    "Pirates of the Caribbean: At World's End",
                                    "2007",
                                    "https://upload.wikimedia.org/wikipedia/en/thumb/5/5a/Pirates_AWE_Poster.jpg/220px-Pirates_AWE_Poster.jpg"
                            ),
                            Movie(
                                    4,
                                    "Pirates of the Caribbean: On Stranger Tides",
                                    "2011",
                                    "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/On_Stranger_Tides_Poster.jpg/220px-On_Stranger_Tides_Poster.jpg"
                            ),
                            Movie(
                                    5,
                                    "Pirates of the Caribbean: Dead Men Tell No Tales",
                                    "2017",
                                    "https://upload.wikimedia.org/wikipedia/en/2/21/Pirates_of_the_Caribbean%2C_Dead_Men_Tell_No_Tales.jpg"
                                    )
                    )
            )
        }
    }

}
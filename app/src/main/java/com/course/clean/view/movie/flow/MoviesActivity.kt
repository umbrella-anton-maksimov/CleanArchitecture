package com.course.clean.view.movie.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.course.clean.R
import com.course.clean.core.FlowManager
import com.course.clean.entity.Movie
import com.course.clean.view.movie.KEY_MOVIE
import com.course.clean.view.movie.details.MovieDetailsFragment
import com.course.clean.view.movie.list.MovieListFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity(), MoviesFlow {

    private val flowManager by lazy {
        FlowManager(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initToolbar()
        initFragment()
    }

    override fun onBackPressed() = back()

    override fun back() = when {
        flowManager.size <= 1 -> finish()
        else                  -> flowManager.popBackStack()
    }

    override fun openMovieDetails(movie: Movie) {
        val params = hashMapOf(KEY_MOVIE to movie)
        flowManager.navigateTo(MovieDetailsFragment::class.java, params)
    }

    private fun showToolbar(visible: Boolean) {
        when (visible) {
            true  -> supportActionBar?.show()
            false -> supportActionBar?.hide()
        }
    }

    private fun showArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    private fun hideArrow() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
    }


    private fun initFragment() {
        flowManager.navigateTo(MovieListFragment::class.java)
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { back() }
        setSupportActionBar(toolbar)
        showToolbar(true)
        hideArrow()
    }
}

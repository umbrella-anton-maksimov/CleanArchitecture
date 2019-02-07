package com.course.clean.view.movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.course.clean.R
import com.course.clean.viewmodel.MovieListViewModel
import com.course.view.HorizontalDivider
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: MovieListViewModel

    //==================== Lifecycle ==========================

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    //==================== Initialization ==========================

    private fun init() {
        initAdapter()
        viewModel.fetchMovies()
    }

    private fun initAdapter() {
        recyclerView.adapter = viewModel.adapter
        val divider = HorizontalDivider(this)
        recyclerView.addItemDecoration(divider)
    }
}

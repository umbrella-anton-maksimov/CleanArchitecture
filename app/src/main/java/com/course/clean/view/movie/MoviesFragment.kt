package com.course.clean.view.movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.course.clean.R
import com.course.clean.viewmodel.MovieListViewModel
import com.course.view.HorizontalDivider
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class MoviesFragment : Fragment() {

    @Inject
    lateinit var viewModel: MovieListViewModel

    //==================== Lifecycle ==========================


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        viewModel.onDestroy()
        super.onDestroyView()
    }

    //==================== Initialization ==========================

    private fun init() {
        initAdapter()
        viewModel.fetchMovies()
    }

    private fun initAdapter() {
        recyclerView.adapter = viewModel.adapter
        val context = context ?: return
        val divider = HorizontalDivider(context)
        recyclerView.addItemDecoration(divider)
    }
}
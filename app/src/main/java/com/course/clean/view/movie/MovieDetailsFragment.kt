package com.course.clean.view.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.course.clean.R
import com.course.clean.core.extentions.load
import com.course.clean.entity.Movie
import com.course.clean.view.base.BaseFragment
import com.course.clean.viewmodel.MovieViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.item_movie.*

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieDetailsFragment : BaseFragment() {

    private val viewModel: MovieViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
    }

    //==================== Lifecycle ==========================


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    //==================== Initialization ==========================

    private fun init() {
        initViewModel()
        initViews()
    }

    private fun initViewModel() {
        val movie: Movie? = arguments?.getParcelable(KEY_MOVIE)
        viewModel.init(movie)
    }

    private fun initViews() {
        viewModel.movie.observe(this, Observer {
            textName.text = it.name
            textYear.text = it.year
            image.load(it.imageUrl)
        })
    }
}
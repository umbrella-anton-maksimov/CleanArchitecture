package com.course.clean.view.movie.details

import android.os.Bundle
import android.view.*
import com.course.clean.R
import com.course.clean.core.extentions.load
import com.course.clean.entity.Movie
import com.course.clean.view.base.BaseFragment
import com.course.clean.view.movie.KEY_MOVIE
import kotlinx.android.synthetic.main.fragment_movie_details.*
import kotlinx.android.synthetic.main.item_movie.*
import javax.inject.Inject

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieDetailsFragment : BaseFragment(), MovieDetailsView {

    @Inject lateinit var presenter: MovieDetailsPresenter

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

    //==================== View (MVP) ==========================

    override fun updateContent(movie: Movie) {
        textName.text = movie.name
        textYear.text = movie.year
        image.load(movie.imageUrl)
    }

    //==================== Initialization ==========================

    private fun init() {
        initPresenter()
    }

    private fun initPresenter() {
        val movie: Movie? = arguments?.getParcelable(KEY_MOVIE)
        presenter.movie = movie
    }


}
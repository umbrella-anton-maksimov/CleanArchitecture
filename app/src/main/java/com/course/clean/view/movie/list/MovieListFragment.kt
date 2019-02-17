package com.course.clean.view.movie.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.course.clean.R
import com.course.clean.entity.Movie
import com.course.clean.view.adapter.movie.MoviesAdapter
import com.course.clean.view.movie.flow.MoviesFlow
import com.course.view.HorizontalDivider
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieListFragment : Fragment(), MovieListView {

    private val flow by lazy { activity as? MoviesFlow }

    @Inject lateinit var presenter: MovieListPresenter

    private val adapter = MoviesAdapter()

    //==================== Lifecycle ==========================

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        presenter.onDestroy()
        super.onDestroyView()
    }

    //==================== View (MVP) ==========================

    override fun updateContent(movies: List<Movie>) {
        adapter.updateContent(movies)
    }

    //==================== Initialization ==========================

    private fun init() {
        initRecyclerView()
        presenter.flow = flow
        presenter.fetchMovies()
    }

    private fun initRecyclerView() {
        adapter.onClickListener = { presenter.onItemClick(it) }
        recyclerView.adapter = adapter
        val context = context ?: return
        val divider = HorizontalDivider(context)
        recyclerView.addItemDecoration(divider)
    }
}
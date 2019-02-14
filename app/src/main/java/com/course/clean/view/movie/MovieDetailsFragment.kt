package com.course.clean.view.movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.course.clean.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.item_movie.*

/**
 * Created by antonmaksimov on 2/13/19.
 * anton.maksimov@umbrella-web.com
 */

class MovieDetailsFragment : Fragment() {


    //==================== Lifecycle ==========================


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        AndroidSupportInjection.inject(this)
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    //
//    override fun onDestroyView() {
//        viewModel.onDestroy()
//        super.onDestroyView()
//    }
//
//    //==================== Initialization ==========================
//

    private fun init() {
        initViews()
    }

    private fun initViews() {

    }

//
//    private fun initAdapter() {
//        recyclerView.adapter = viewModel.adapter
//        val context = context ?: return
//        val divider = HorizontalDivider(context)
//        recyclerView.addItemDecoration(divider)
//    }
}
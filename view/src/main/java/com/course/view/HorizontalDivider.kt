package com.course.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by antonmaksimov on 2/3/19.
 * anton.maksimov@umbrella-web.com
 */

//class HorizontalDivider: RecyclerView.ItemDecoration() {
//    o
//}

class HorizontalDivider(context: Context) : RecyclerView.ItemDecoration() {

    private val divider: Drawable? = ContextCompat.getDrawable(context, R.drawable.horizontal_divider_grey)

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (divider == null) return
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}
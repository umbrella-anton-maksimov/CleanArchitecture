package com.course.clean.core.extentions

import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.apache.commons.text.StringEscapeUtils

/**
 * Created by antonmaksimov on 2/16/19.
 * anton.maksimov@umbrella-web.com
 */

fun ImageView.load(url: String?) {
    val url = StringEscapeUtils.unescapeJava(url)
    Picasso.get()
        .load(url)
        .into(this)
}
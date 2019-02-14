package com.course.clean.core

import android.os.*
import java.io.Serializable

/**
 * Created by antonmaksimov on 2/14/19.
 * anton.maksimov@umbrella-web.com
 */

fun <V> Map<String, V>.toBundle(bundle: Bundle = Bundle()): Bundle = bundle.apply {
    forEach {
        val key = it.key
        val value = it.value
        when (value) {
            is IBinder      -> putBinder(key, value)
            is Bundle       -> putBundle(key, value)
            is Byte         -> putByte(key, value)
            is ByteArray    -> putByteArray(key, value)
            is Char         -> putChar(key, value)
            is CharArray    -> putCharArray(key, value)
            is CharSequence -> putCharSequence(key, value)
            is Float        -> putFloat(key, value)
            is FloatArray   -> putFloatArray(key, value)
            is Parcelable   -> putParcelable(key, value)
            is Serializable -> putSerializable(key, value)
            is Short        -> putShort(key, value)
            is ShortArray   -> putShortArray(key, value)

            else            -> throw IllegalArgumentException(
                    "$value is of a type that is not currently supported")

        }
    }
}
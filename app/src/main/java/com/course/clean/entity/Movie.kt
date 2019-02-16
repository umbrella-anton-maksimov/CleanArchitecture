package com.course.clean.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by antonmaksimov on 1/27/19.
 * anton.maksimov@umbrella-web.com
 */

data class Movie(val id: Long,
                 val name: String,
                 val year: String,
                 val imageUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(year)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
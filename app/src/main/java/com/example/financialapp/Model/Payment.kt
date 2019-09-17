package com.example.financialapp.Model

import android.os.Parcel
import android.os.Parcelable

data class Payment (
    val uuid: String?,
    val description: String,
    val price: String,
    val date: String,
    val organization: String?
) : Parcelable {

    constructor() : this("","","","","")

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(description)
        parcel.writeString(price)
        parcel.writeString(date)
        parcel.writeString(organization)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Payment> {
        override fun createFromParcel(parcel: Parcel): Payment {
            return Payment(parcel)
        }

        override fun newArray(size: Int): Array<Payment?> {
            return arrayOfNulls(size)
        }
    }
}
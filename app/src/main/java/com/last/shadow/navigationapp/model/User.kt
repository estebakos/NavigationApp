package com.last.shadow.navigationapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val userName: String, val email: String) : Parcelable
package com.yungchi.testing.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventTypeSpinModel(
        @field:SerializedName("CLS_CODE")
        var CLS_CODE: String,
        @field:SerializedName("CLS_NM")
        var CLS_NM: String,
        @field:SerializedName("BRCOLOR")
        var BRCOLOR: String,
        @field:SerializedName("BGCOLOR")
        var BGCOLOR: String
) : Parcelable

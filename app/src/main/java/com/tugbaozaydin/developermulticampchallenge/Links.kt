package com.tugbaozaydin.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("instagram")
    @Expose
    val instagram: String,
    @SerializedName("twitter")
    @Expose
    val twitter: String,
    @SerializedName("youtube")
    @Expose
    val youtube: String,
    @SerializedName("participation")
    @Expose
    val participation: String
)
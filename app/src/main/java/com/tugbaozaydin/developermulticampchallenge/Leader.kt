package com.tugbaozaydin.developermulticampchallenge

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Leader(

    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("photo")
    @Expose
    val photo:String

    )
package com.tugbaozaydin.developermulticampchallenge


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tugbaozaydin.myapplication.Links

data class Data (

    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("banner")
    @Expose
    val banner: String,
    @SerializedName("leader")
    @Expose
    val leader: Leader,
    @SerializedName("links")
    @Expose
    val links: Links

    )
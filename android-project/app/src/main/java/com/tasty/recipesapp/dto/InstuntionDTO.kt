package com.tasty.recipesapp.dto

import com.google.gson.annotations.SerializedName

data class InstuntionDTO (
    @SerializedName("display_text")
    val displayText: String,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("end_time")
    val endTime: Int)
package com.example.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("capital"  ) var capital  : String?   = null,
    @SerializedName("code"     ) var code     : String?   = null,
    @SerializedName("name"     ) var name     : String?   = null,
    @SerializedName("region"   ) var region   : String?   = null
)

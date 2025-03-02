package com.example.networkService

object AllApi {
    private external fun baseUrlFromJNI(boolean: Boolean): String

    const val BASE_URL = "https://gist.githubusercontent.com/"

    private const val V1 = "peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"

    const val DATA_LIST = V1 + "countries.json"
}
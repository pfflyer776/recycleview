package com.example.networkService

import com.example.model.DataModel
import retrofit2.http.GET

interface RetrofitInterface {
    @GET(AllApi.DATA_LIST)
    suspend fun getCountryList(): List<DataModel>
}
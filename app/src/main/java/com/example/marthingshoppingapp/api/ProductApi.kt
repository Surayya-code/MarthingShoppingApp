package com.example.marthingshoppingapp.api

import com.example.marthingshoppingapp.model.fakeStoreProduct.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("getProduct")
    fun getAllProduct():Call<ProductResponse>

}
package com.example.marthingshoppingapp.service

import com.example.marthingshoppingapp.model.fakeStoreProduct.CategoriesResponse
import com.example.marthingshoppingapp.model.fakeStoreProduct.FProductResponse
import com.example.marthingshoppingapp.model.fakeStoreProduct.ProductResponse
import com.example.marthingshoppingapp.model.fakeStoreProduct.TokenResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Service {

    @POST("auth/login")
    @FormUrlEncoded
    fun userLogin(@Field("username") username:String,@Field("password") password:String):Call<TokenResponse>

    @GET("products")
    fun getProducts(@Query("limit") limit:Int,
                    @Query("sort") sort:String) : Call<ProductResponse>

   @GET("products")
   fun getFakeProducts():Call<FProductResponse>

    @GET("categories")
    fun getFakeCategories():Call<CategoriesResponse>


    ///CategoryResponse=List<CategoryResponseItem>
}
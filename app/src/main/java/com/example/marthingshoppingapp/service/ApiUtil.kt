package com.example.marthingshoppingapp.service

import com.example.marthingshoppingapp.utils.BASE_URL
import com.example.marthingshoppingapp.utils.BASE_URL2

class ApiUtil {
    companion object{
        fun getService():Service{
            return RetrofitUtil.getRetrofit(BASE_URL).create(Service::class.java)
        }
        fun getProductService():Service{
            return RetrofitUtil.getRetrofit(BASE_URL2).create(Service::class.java)
        }
    }
}
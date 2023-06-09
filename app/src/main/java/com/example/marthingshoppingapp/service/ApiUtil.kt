package com.example.marthingshoppingapp.service

import com.example.marthingshoppingapp.utils.BASE_URL

class ApiUtil {
    companion object{
        fun getService():Service{
            return RetrofitUtil.getRetrofit(BASE_URL).create(Service::class.java)
        }
    }
}
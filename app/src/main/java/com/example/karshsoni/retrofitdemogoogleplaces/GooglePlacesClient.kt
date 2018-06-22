package com.example.karshsoni.retrofitdemogoogleplaces

import retrofit2.Call
import retrofit2.http.*

interface GooglePlacesClient{
    @GET("/maps/api/place/findplacefromtext/json")
    fun sendRequestForPlaces(@Query("input") input: String, @Query("inputtype") inputtype: String, @Query("fields") fields:String, @Query("key") key:String): Call<ModelClass>
}
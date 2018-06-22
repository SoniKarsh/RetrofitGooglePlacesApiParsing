package com.example.karshsoni.retrofitdemogoogleplaces

data class PhotosItem(val photoReference: String = "",
                      val width: Int = 0,
                      val htmlAttributions: List<String>?,
                      val height: Int = 0)
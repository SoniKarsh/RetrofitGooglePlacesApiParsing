package com.example.karshsoni.retrofitdemogoogleplaces

data class CandidatesItem(val formattedAddress: String = "",
                          val name: String = "",
                          val geometry: Geometry,
                          val photos: List<PhotosItem>?)
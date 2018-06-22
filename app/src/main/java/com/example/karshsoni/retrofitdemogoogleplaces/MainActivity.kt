package com.example.karshsoni.retrofitdemogoogleplaces

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //    lateinit var address: String
    val BASE_URL = "https://maps.googleapis.com"
    val API_KEY = "AIzaSyDNW19-fD8Ef6ViPfC25CQ3zrHepBcoq_M"
    //    https://maps.googleapis.com/maps/api/
    val geometry: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        var retrofit: Retrofit = builder.build()

        var client: GooglePlacesClient = retrofit.create(GooglePlacesClient::class.java)
        button.setOnClickListener {
            var address = editText.text.toString()
            var call = client.sendRequestForPlaces(address, "textquery", "photos,formatted_address,name,rating,opening_hours,geometry", "AIzaSyDNW19-fD8Ef6ViPfC25CQ3zrHepBcoq_M")
            call.enqueue(object : Callback<ModelClass> {
                override fun onFailure(call: Call<ModelClass>?, t: Throwable?) {
                    Toast.makeText(applicationContext, "error:( ", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ModelClass>?, response: Response<ModelClass>?) {
                    Toast.makeText(applicationContext, "Success: " + response!!.body(), Toast.LENGTH_LONG).show()
                    val layout = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = DataAdapter(response.body()!!, this@MainActivity)
                    recyclerView.layoutManager = layout

                }
            })
        }
    }
}

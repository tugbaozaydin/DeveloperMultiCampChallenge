package com.tugbaozaydin.developermulticampchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var dataService: ApiInterface
    lateinit var dataList: MutableList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataService = ApiClient.getClient().create(ApiInterface::class.java)
        var data = dataService.getData()

        data.enqueue(object : Callback<List<Data>> {
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                if (response.isSuccessful) {
                    dataList = (response.body() as MutableList<Data>?)!!
                    dataRecyclerList.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    dataRecyclerList.adapter = Adapter(dataList)
                }
            }
        })
    }
}
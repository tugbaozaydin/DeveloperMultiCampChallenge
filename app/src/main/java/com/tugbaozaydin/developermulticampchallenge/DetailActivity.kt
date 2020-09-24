package com.tugbaozaydin.developermulticampchallenge

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    lateinit var dataService: ApiInterface
    lateinit var dataList: MutableList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var id = intent.getIntExtra("id", 0)
        dataService = ApiClient.getClient().create(ApiInterface::class.java)
        var data = dataService.getData()

        data.enqueue(object : Callback<List<Data>> {
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                if (response.isSuccessful) {
                    dataList = (response.body() as MutableList<Data>?)!!
                    description.setText(dataList[id].description)
                    Picasso.with(applicationContext).load(dataList[id].banner).into(banner)
                    Picasso.with(applicationContext).load(dataList[id].leader.photo).into(leadphoto)
                    leadname.setText(dataList[id].leader.name)
                    twitter.setOnClickListener {

                        startActivity(
                            Intent(Intent.ACTION_VIEW, Uri.parse(dataList[id].links.twitter))
                        )
                    }
                    instagram.setOnClickListener {

                        startActivity(
                            Intent(Intent.ACTION_VIEW, Uri.parse(dataList[id].links.instagram))
                        )
                    }
                    youtube.setOnClickListener {

                        startActivity(
                            Intent(Intent.ACTION_VIEW, Uri.parse(dataList[id].links.youtube))
                        )
                    }   
                    participation.setOnClickListener {

                        startActivity(
                            Intent(Intent.ACTION_VIEW, Uri.parse(dataList[id].links.participation))
                        )
                    }
                    
                }
            }
        })
    }
}

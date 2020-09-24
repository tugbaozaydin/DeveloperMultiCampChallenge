package com.tugbaozaydin.developermulticampchallenge

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(val countryList: MutableList<Data>) :
    RecyclerView.Adapter<Adapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val bannerImage: ImageView = view.findViewById(R.id.bannerImage)
        val itemCard: CardView = view.findViewById(R.id.itemCard)

        fun bindItems(item: Data, position: Int) {

            //  bannerImage.setImageURI(Uri.parse(item.banner))
            Picasso.with(itemView.context).load(item.banner).into(bannerImage)
          /*  itemCard.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("id", position)
                itemView.context.startActivity(intent)
            }*/

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(countryList.get(position), position)
    }
}
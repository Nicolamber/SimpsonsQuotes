package com.nlambertucci.simpsonsquotes.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nlambertucci.simpsonsquotes.R
import com.nlambertucci.simpsonsquotes.model.Quotes

class QuotesAdapter (
    private val quotesList: List<Quotes>
): RecyclerView.Adapter<QuotesAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = ViewHolder(LayoutInflater.from(context).inflate(R.layout.quotesitem,parent,false))
        return view
    }

    override fun getItemCount(): Int {
       return quotesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotesList?.get(position)

            context?.let {
                Glide.with(it)
                    .load(quote?.image)
                    .into(holder.character)
            }

        holder.quote.setText(quote?.quote)
        holder.characterName.setText(quote?.character)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val character: ImageView = itemView.findViewById(R.id.characterImg)
        val quote: TextView = itemView.findViewById(R.id.quote)
        val characterName: TextView = itemView.findViewById(R.id.CharacterName)
    }
}


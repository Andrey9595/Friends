package ru.anb.friends.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.anb.friends.R

class FriendsAdapter(private  val names: List<String>) : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    class FriendsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.friends_item, parent, false)
        return FriendsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.text.text = names[position]
    }

    override fun getItemCount(): Int {
        return names.size
    }
}
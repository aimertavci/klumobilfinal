package com.example.klumobilfinal

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import  com.example.klumobilfinal.data.models.Post
import com.example.klumobilfinal.databinding.ActivityRowKategoriBinding

class kategori_adapter(val landmarkList : ArrayList<Post>) : RecyclerView.Adapter<kategori_adapter.LandmarkHolder>() {
    class LandmarkHolder(val binding : ActivityRowKategoriBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = ActivityRowKategoriBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerRowTextView.text = landmarkList.get(position).title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,kategori_yerler::class.java)
            intent.putExtra("landmark",landmarkList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }

}
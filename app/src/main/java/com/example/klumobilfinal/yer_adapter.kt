package com.example.klumobilfinal

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import  com.example.klumobilfinal.data.models.Yer
import com.example.klumobilfinal.databinding.ActivityRowYerlerBinding

class yer_adapter(val landmarkList : ArrayList<Yer>) : RecyclerView.Adapter<yer_adapter.LandmarkHolder>() {
    class LandmarkHolder(val binding : ActivityRowYerlerBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = ActivityRowYerlerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerRowTextView.text = landmarkList.get(position).ad
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,yerdetay::class.java)
            intent.putExtra("landmark",landmarkList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }

}
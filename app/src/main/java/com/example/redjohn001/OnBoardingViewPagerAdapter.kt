package com.example.redjohn001

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnBoardingViewPagerAdapter(
    private var imageList: List<Int>,
    private var titleList: List<String>,
    private var descriptionList: List<String>
) : RecyclerView.Adapter<OnBoardingViewPagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.on_boarding_title_txt)
        val itemDescription: TextView = itemView.findViewById(R.id.on_boarding_description_txt)
        val itemImage: ImageView = itemView.findViewById(R.id.on_boarding_img)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardingViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.on_boarding_layout_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(
        holder: OnBoardingViewPagerAdapter.Pager2ViewHolder,
        position: Int
    ) {
        holder.itemTitle.text = titleList[position]
        holder.itemDescription.text = descriptionList[position]
        holder.itemImage.setImageResource(imageList[position])
    }

}
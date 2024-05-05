package com.ellycrab.imagesearch.presentation.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellycrab.imagesearch.databinding.ImgsearchrsBinding
import com.ellycrab.imagesearch.presentation.adapter.ImgAdapter
import com.ellycrab.imagesearch.presentation.search.fragments.SearchFragment
import com.ellycrab.imagesearch.presentation.search.model.ImageDocumentEntity
import java.text.SimpleDateFormat
import java.util.Date

class ImageViewHolder(val binding:ImgsearchrsBinding, val switchStateChangeListener: ImgAdapter.OnSwitchStateChangeListener)
    :RecyclerView.ViewHolder(binding.root) {


    fun bind(data: ImageDocumentEntity){
        Glide.with(itemView.context)
            .load(data.thumbnailUrl)
            .into(binding.imageViewThumbnail)

        binding.displaySitename.text = data.displaySitename

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formattedDateTime = dateFormat.format(data.datetime)
        binding.datetime.text = formattedDateTime

        binding.switch1.setOnCheckedChangeListener  {
                _,isChecked->
            switchStateChangeListener.onSwitchStateChanged(adapterPosition,isChecked)

            if(isChecked){
                binding.like.visibility = View.VISIBLE

            }else{
                binding.like.visibility = View.GONE

            }

        }

    }
}
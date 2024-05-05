package com.ellycrab.imagesearch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ellycrab.imagesearch.databinding.ImgsearchrsBinding
import com.ellycrab.imagesearch.presentation.callback.ImgDiffCallback
import com.ellycrab.imagesearch.presentation.search.fragments.SearchFragment
import com.ellycrab.imagesearch.presentation.search.model.ImageDocumentEntity
import com.ellycrab.imagesearch.presentation.viewholder.ImageViewHolder

class ImgAdapter(private val switchStateChangeListener: OnSwitchStateChangeListener) :
    ListAdapter<ImageDocumentEntity, RecyclerView.ViewHolder>(
        ImgDiffCallback()
    ) {






    //이미지어댑터에서 북마크할때
    interface OnSwitchStateChangeListener {
        fun onSwitchStateChanged(position: Int, isChecked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = ImageViewHolder(
            ImgsearchrsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            switchStateChangeListener
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            val imageDocumentEntity = getItem(position) as ImageDocumentEntity
            holder.bind(imageDocumentEntity)

            // 스위치 상태 변경 리스너 설정
            holder.binding.switch1.setOnCheckedChangeListener { _, isChecked ->
                // ImgAdapter의 리스너 호출
                switchStateChangeListener.onSwitchStateChanged(position, isChecked)
            }
        }
    }



}
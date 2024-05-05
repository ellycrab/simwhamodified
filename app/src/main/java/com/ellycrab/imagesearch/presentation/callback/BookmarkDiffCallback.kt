package com.ellycrab.imagesearch.presentation.callback

import androidx.recyclerview.widget.DiffUtil
import com.ellycrab.imagesearch.presentation.search.model.ImageDocumentEntity

class BookmarkDiffCallback: DiffUtil.ItemCallback<ImageDocumentEntity>() {
    override fun areItemsTheSame(
        oldItem: ImageDocumentEntity,
        newItem: ImageDocumentEntity
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: ImageDocumentEntity,
        newItem: ImageDocumentEntity
    ): Boolean {
        return oldItem == newItem
    }
}
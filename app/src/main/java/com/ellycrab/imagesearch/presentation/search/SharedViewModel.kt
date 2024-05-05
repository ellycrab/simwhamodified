package com.ellycrab.imagesearch.presentation.search

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ellycrab.imagesearch.presentation.search.model.ImageDocumentEntity

class SharedViewModel: ViewModel() {
    val bookmarkedItems = MutableLiveData<List<ImageDocumentEntity>>()
    val searchResults = MutableLiveData<List<ImageDocumentEntity>>()

}
package com.example.prj_trocainfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object GlobalCounter {

    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun increment(){
        _count.value = (count.value ?: 0) + 1
    }

    fun decrement(){
        _count.value = (count.value ?: 0) - 1
    }

}
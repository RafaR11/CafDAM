package com.example.cafdam

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class carritoViewModel: ViewModel() {
    val plat = MutableLiveData<String>()
    val plat2 = MutableLiveData<String>()
    val plat3 = MutableLiveData<String>()
    fun sendPlat1(text: String){
        plat.value = text
    }
    fun sendPlat2(text2: String){
        plat2.value = text2
    }
    fun sendPlat3(text3: String){
        plat3.value = text3
    }

}
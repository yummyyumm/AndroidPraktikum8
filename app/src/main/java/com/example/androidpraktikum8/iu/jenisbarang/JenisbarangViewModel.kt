package com.example.androidpraktikum8.iu.jenisbarang

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpraktikum8.model.Jenisbarang
import com.example.androidpraktikum8.network.Api
import kotlinx.coroutines.launch

class JenisbarangViewModel : ViewModel() {
    val response = MutableLiveData<Jenisbarang>()

    fun getJenisbarang() {
        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getJenisbarang()
                response.value = listResult
            } catch (e: Exception) {
                response.value = null
            }
        }
    }
}
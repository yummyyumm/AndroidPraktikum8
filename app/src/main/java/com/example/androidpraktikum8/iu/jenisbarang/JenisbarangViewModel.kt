package com.example.androidpraktikum8.iu.jenisbarang

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpraktikum8.model.Jenisbarang
import com.example.androidpraktikum8.model.JenisbarangData
import com.example.androidpraktikum8.model.JenisbarangResponse
import com.example.androidpraktikum8.network.Api
import kotlinx.coroutines.launch
import okhttp3.Response

class JenisbarangViewModel : ViewModel() {
    val response = MutableLiveData<Jenisbarang>()
    val createResponse = MutableLiveData<Response<JenisbarangResponse>>()

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

    fun create(jenisbarangData: JenisbarangData) {
        viewModelScope.launch {
            val response = Api.retrofitService.create(jenisbarangData)
            createResponse.value = response
        }
    }
}
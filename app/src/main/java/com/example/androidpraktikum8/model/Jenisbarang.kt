package com.example.androidpraktikum8.model

import com.squareup.moshi.Json

data class Jenisbarang(
    val success: Boolean,
    val data : List<JenisbarangData>,
    val message: String
)

data class JenisbarangData(
    @field:Json(name = "@id")
    val id: String,
    @field:Json(name = "@namajenisbarang")
    val namajenisbarang: String
)
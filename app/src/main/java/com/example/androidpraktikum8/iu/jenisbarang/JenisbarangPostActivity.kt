package com.example.androidpraktikum8.iu.jenisbarang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.androidpraktikum8.R
import com.example.androidpraktikum8.databinding.ActivityJenisbarangPostBinding
import com.example.androidpraktikum8.model.JenisbarangData

class JenisbarangPostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJenisbarangPostBinding
    private val viewModel: JenisbarangViewModel by lazy {
        ViewModelProvider(this).get(JenisbarangViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisbarangPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBarJenisbarangPost.visibility = View.INVISIBLE
        binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
        binding.btSimpanJenisbarangPost.setOnClickListener{
            val status = intent.getStringExtra("STATUS")
            if(status=="TAMBAH"){
                binding.etIdJenisbarang.visibility  = View.GONE
            } else {
                binding.etIdJenisbarang.visibility  = View.VISIBLE
            }
            binding.etNamajenisbarang.requestFocus()

            val idJenisbarang = binding.etIdJenisbarang.text.toString()
            val namaJenisBarang = binding.etNamajenisbarang.text.toString()
            val jenisBarangData = JenisbarangData(idJenisbarang,namaJenisBarang)

            binding.progressBarJenisbarangPost.visibility = View.VISIBLE
            binding.btSimpanJenisbarangPost.visibility = View.INVISIBLE

            if(status == "TAMBAH"){
                viewModel.create(jenisBarangData)
                viewModel.createResponse.observe(this,{
                    binding.progressBarJenisbarangPost.visibility = View.INVISIBLE
                    binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
                    Toast.makeText(this, it.body()?.message,Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK)
                    finish()
                })


                viewModel.create(jenisBarangData)
            viewModel.createResponse.observe(this,{
                binding.progressBarJenisbarangPost.visibility = View.INVISIBLE
                binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
                Toast.makeText(this, it.body()?.message,Toast.LENGTH_SHORT).show()
            })
        }
    }
}
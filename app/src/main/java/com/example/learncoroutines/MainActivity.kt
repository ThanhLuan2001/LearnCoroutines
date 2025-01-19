package com.example.learncoroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.learncoroutines._5_coroutines_with_api.MyApi
import com.example.learncoroutines._5_coroutines_with_api.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val myApi : MyApi = RetrofitHelper.myApi
    lateinit var tvUser: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvUser = findViewById(R.id.tvName)
        lifecycleScope.launch(Dispatchers.IO) {

            val response = myApi.getUsers()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    tvUser.text = "${response.body()?.name} - ${response.body()?.age} - ${response.body()?.address}"

                }
            }
        }


    }
}
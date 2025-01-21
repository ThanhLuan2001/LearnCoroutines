package com.example.learncoroutines.shared_preferences

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learncoroutines.R
import com.example.learncoroutines.broadcast_receiver.MyBroadCastReceiver
import com.example.learncoroutines.databinding.ActivityDataLocalBinding

class DataLocalActivity : AppCompatActivity() {


    private lateinit var myBroadCastReceiver : MyBroadCastReceiver

    private lateinit var binding : ActivityDataLocalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDataLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            edtName1.setText(DataLocalManager.getName())
            btn1.setOnClickListener {
                saveSharedPreferences()
                val intent = Intent("com.example.learncoroutines")
                intent.putExtra("message", "Hello")
                sendBroadcast(intent)
            }
        }

        myBroadCastReceiver = MyBroadCastReceiver()
        val intentFilter = IntentFilter("com.example.learncoroutines")
        registerReceiver(myBroadCastReceiver,intentFilter)


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadCastReceiver)
    }
    private fun sendMessage(){

    }

    private fun saveSharedPreferences() {
        DataLocalManager.setName(binding.edtName1.text.toString())
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
    }
}
package com.example.connectivitycheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.connectivitycheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectionLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetworkConnectionLiveData()
    }

    private fun checkNetworkConnectionLiveData(){

        connectivityLiveData = ConnectionLiveData(application)

        connectivityLiveData.observe(this, { isAvailable ->
            when(isAvailable){
                true -> binding.tvConnection.text = "Internet is working!"
                false -> binding.tvConnection.text = "Internet is not working!"
            }
        })
    }
}
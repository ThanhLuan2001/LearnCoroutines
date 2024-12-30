package com.example.learncoroutines._1_couroutines_scope.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.learncoroutines.databinding.FragmentLifecyclerFagmentBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifecycleFragment : Fragment() {
    private lateinit var binding : FragmentLifecyclerFagmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLifecyclerFagmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handle()
    }

    private fun handle() {
        showLoading(true)
        lifecycleScope.launch {
            try {
                val data = fetchDataFromServer()
                Log.d("LifecycleScope", "Dữ liệu lấy được : $data")
                showLoading(false)
                updateUI(data)
            } catch (e: Exception) {
                showLoading(false)
                Log.e("LifecycleScope", "Lỗi - ${e.message}")
            }
        }
    }

    private suspend fun fetchDataFromServer(): String {
        delay(2000L)
        return "Jack - J97"
    }

    private fun showLoading(state: Boolean) {
        binding.loading.isVisible = state
    }

    private fun updateUI(data: String) {
        binding.tvContent.text = data
    }
}
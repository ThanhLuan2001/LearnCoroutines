package com.example.learncoroutines._2_Dispatcher

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.learncoroutines.databinding.FragmentLoadFileBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoadFileFragment : Fragment(){
    private lateinit var binding : FragmentLoadFileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadFileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)
        CoroutineScope(Dispatchers.IO).launch {
            val data = fetchDataFromFile()
            withContext(Dispatchers.Main) {
                showLoading(false)
                updateUI(data)
            }
        }
    }

    private fun showLoading(state: Boolean) {
        binding.loading.isVisible = state
    }
    private suspend fun fetchDataFromFile(): Uri {
        delay(3000)
        return Uri.parse("abcd")
    }

    private fun updateUI(data: Uri) {
        binding.imgPhoto.setImageURI(data)
    }
}
package com.example.learncoroutines._1_couroutines_scope.view_model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.learncoroutines.databinding.FragmentViewModelBinding

class ViewModelFragment : Fragment() {

    private lateinit var binding : FragmentViewModelBinding
    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewModelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadData()
        viewModel.dataAPI.observe(viewLifecycleOwner) { dataAPI ->
            binding.tvContent.text = dataAPI
        }
    }

}
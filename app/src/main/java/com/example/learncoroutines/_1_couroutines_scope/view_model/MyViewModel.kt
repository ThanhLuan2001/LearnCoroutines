package com.example.learncoroutines._1_couroutines_scope.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class MyViewModel(private val repository: DataRepository) : ViewModel() {

    var dataAPI: MutableLiveData<String> = MutableLiveData()

    fun loadData() {
        viewModelScope.launch {
            try {
                val data = repository.fetchDataFromApi()
                repository.saveDataToDatabase(data)
                dataAPI.postValue(data)
                Log.d("ViewModelScope", "Dữ liệu lấy được : $data")
            } catch (e: Exception) {
                Log.e("ViewModelScope", "Lỗi - ${e.message}")

            }
        }
    }
}

class DataRepository {
    suspend fun fetchDataFromApi(): String {
        delay(3000L)
        return "Dữ liệu từ API"
    }

    suspend fun saveDataToDatabase(data: String) {
        delay(1000L)
        //thực hiện công việc lưu dữ liệu vào trong database
        println("Data saved to database: $data")
    }

    suspend fun fetchData(): String {
        delay(1000) // Giả lập tác vụ lâu
        return "Hello, World!"
    }
}
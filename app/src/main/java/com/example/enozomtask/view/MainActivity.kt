package com.example.enozomtask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.R
import com.example.enozomtask.model.remote_source.RemoteSource
import com.example.enozomtask.model.task_repo.TaskRepo
import com.example.enozomtask.pojo.TaskResult
import com.example.enozomtask.viewmodel.DataViewmodel
import com.example.enozomtask.viewmodel.DataViewmodelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel: DataViewmodel
    private lateinit var dataViewModelFactory: DataViewmodelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataViewModelFactory = DataViewmodelFactory(
            TaskRepo.getInstance(RemoteSource.getInstance())
        )

        dataViewModel =
            ViewModelProvider(this, dataViewModelFactory)[DataViewmodel::class.java]

        dataViewModel.getDataFromApi()
        dataViewModel.dataLiveData.observe(this) {
            val passwordObj = TaskResult(getPassword(it.indexes, it.text))
            dataViewModel.submitResult(passwordObj)
        }
    }

    private fun getPassword(indexes: String, text: String): String {
        var splitedIndices: List<String> = indexes.split(",")
        var stringBuilder: StringBuilder = StringBuilder()
        for (i in 0..splitedIndices.size - 1) {
            val value = text.get(splitedIndices.get(i).toString().toInt())
            stringBuilder.append(value)
        }
        return stringBuilder.toString()
    }
}
package com.example.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarch.R
import com.example.cleanarch.app.App
import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.domain.models.SaveParam
import com.example.domain.models.UserName
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appCompanent.inject(this)

        Log.e("AAA", "Activity Created")

        vm = ViewModelProvider(this, vmFactory)
            .get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendBtn = findViewById<Button>(R.id.sendButton)
        val receiveBtn = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })

        sendBtn.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        receiveBtn.setOnClickListener {
            vm.load()
        }
    }
}
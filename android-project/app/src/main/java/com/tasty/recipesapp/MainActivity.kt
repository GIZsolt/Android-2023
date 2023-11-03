package com.tasty.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        val view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
        val name = intent.extras?.getString("name")
        view.textGreeting.text = "Hello $name"
    }
}
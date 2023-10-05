package com.example.customviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding ?: error("binding isn`t set")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.fcMain, FigureFragment()).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
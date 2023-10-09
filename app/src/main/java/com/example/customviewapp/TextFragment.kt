package com.example.customviewapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.customviewapp.databinding.TextFragmentBinding

class TextFragment : Fragment() {
    private lateinit var binding: TextFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = TextFragmentBinding.inflate(inflater, container, false)
        binding.root.addItem(getString(R.string.text))
        return binding.root
    }
}

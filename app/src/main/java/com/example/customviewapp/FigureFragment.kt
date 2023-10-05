package com.example.customviewapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.customviewapp.databinding.FigureFragmentBinding

class FigureFragment : Fragment() {
    private var _binding: FigureFragmentBinding? = null
    private val binding get() = _binding ?: error("binding isn`t set")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FigureFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icNextScreen.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fcMain, TextFragment()).commit()
        }
    }
}
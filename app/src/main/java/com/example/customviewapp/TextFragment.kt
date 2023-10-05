package com.example.customviewapp

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView

class TextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val linearLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
        }
        val llParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        with(linearLayout) {
            layoutParams = llParams
            addItem(this)
        }
        return linearLayout
    }

    private fun addItem(linearLayout: LinearLayout) {
        val textView = MaterialTextView(requireContext())
        val tvParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        with(textView) {
            layoutParams = tvParams
            text = getString(R.string.text)
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            setBackgroundColor(ContextCompat.getColor(requireContext(), android.R.color.black))
        }

        with(tvParams) {
            topMargin = 48.px
        }
        linearLayout.addView(textView)
    }
}

val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()


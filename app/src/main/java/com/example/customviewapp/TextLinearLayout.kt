package com.example.customviewapp

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.textview.MaterialTextView

class TextLinearLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = VERTICAL
    }

    fun addItem(text: String) {
        val textView = MaterialTextView(context)
        val tvParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        with(textView) {
            layoutParams = tvParams
            this.text = text
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.black))
        }

        with(tvParams) {
            topMargin = 48.px
        }
        addView(textView)
    }
}
val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()


package com.example.customviewapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {
    private var cornerRadius: Float = 0f
    private var strokeWidth: Float = 0f
    private var strokeColor = Color.TRANSPARENT
    private val path = Path()
    private val rectF = RectF()

    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0,
            0
        )
        try {
            cornerRadius = typedArray.getDimension(R.styleable.CustomView_cornerRadius, 0f)
            strokeWidth = typedArray.getDimension(R.styleable.CustomView_strokeWidth, 0f)
            strokeColor = typedArray.getColor(R.styleable.CustomView_strokeColor, Color.TRANSPARENT)
        } finally {
            typedArray.recycle()
        }
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.strokeWidth = strokeWidth
        paint.color = strokeColor
        rectF.set(
            0f, 0f, width.toFloat(), height.toFloat()
        )
        path.reset()
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas?.drawPath(path, paint)
    }
}
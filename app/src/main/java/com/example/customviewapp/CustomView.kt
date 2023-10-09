package com.example.customviewapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import java.lang.Integer.min

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
    }
    private val rectF = RectF()
    private val path = Path()
    private var cornerRadius: Float = 0f
    private var strokeWidth: Float = 0f
    private var strokeColor = Color.TRANSPARENT

    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0,
            0
        )
        try {
            cornerRadius = typedArray.getDimension(R.styleable.CustomView_cornerRadius, 0f)
            strokeWidth = typedArray.getDimension(R.styleable.CustomView_strokeWidth, 4f)
            strokeColor = typedArray.getColor(R.styleable.CustomView_strokeColor, Color.BLACK)
        } finally {
            typedArray.recycle()
        }
        paint.strokeWidth = strokeWidth
        paint.color = strokeColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val contentWidth = 2 * (cornerRadius + strokeWidth).toInt()
        val contentHeight = 2 * (cornerRadius + strokeWidth).toInt()

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> min(contentWidth, widthSize)
            else -> contentWidth
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> min(contentHeight, heightSize)
            else -> contentHeight
        }

        setMeasuredDimension(width, height)

        rectF.set(
            0f + strokeWidth / 2,
            0f + strokeWidth / 2,
            width.toFloat() - strokeWidth / 2,
            height.toFloat() - strokeWidth / 2
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW)
        canvas?.drawPath(path, paint)
    }
}
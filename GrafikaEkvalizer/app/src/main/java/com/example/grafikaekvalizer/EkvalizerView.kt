package com.example.grafikaekvalizer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

/**
 * TODO: document your custom view class.
 */
class EkvalizerView : View {

    var kanalyArray: FloatArray = floatArrayOf();
    lateinit var linePaint: Paint
    lateinit var ballPaint: Paint

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    fun setData(kanaly: FloatArray) {
        this.kanalyArray = kanaly;
        invalidate()
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        linePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        linePaint.setColor(ContextCompat.getColor(context, R.color.black))
        linePaint.strokeWidth = 4f;
        ballPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        ballPaint.setColor(ContextCompat.getColor(context, R.color.black))
        ballPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (kanalyArray.isEmpty()) return

        val viewWidth = width.toFloat()
        val viewHeight = height.toFloat()
        val channelCount = kanalyArray.size

        val stepX = viewWidth / channelCount

        for (i in kanalyArray.indices) {
            val xPoz = stepX * i + (stepX / 2f)
            canvas.drawLine(xPoz, 5f, xPoz, viewHeight, linePaint)

            val normalizedValue = (kanalyArray[i]).coerceIn(0f, 1f)
            println("normalizedValue "+normalizedValue)
            val ekvPoz = viewHeight - (normalizedValue * (viewHeight-5f))
            println("ekvPoz "+ekvPoz)
            println("viewHeight "+viewHeight)

            canvas.drawCircle(xPoz, ekvPoz, 16f, ballPaint)
        }
    }
}
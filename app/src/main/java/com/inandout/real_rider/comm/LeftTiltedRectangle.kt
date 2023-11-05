package com.inandout.real_rider.comm

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class LeftTiltedRectangle(context: Context?, attrs: AttributeSet) : View(context, attrs) {
    private val paint: Paint

    init {
        paint = Paint()
        paint.color = resources.getColor(R.color.holo_blue_light)
        paint.style = Paint.Style.FILL
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = height

        // 왼쪽 사다리꼴 모양의 사각형을 그립니다
        val points = floatArrayOf(
            0f,
            0f,
            width * 0.3f,
            0f,
            0f,
            height.toFloat(),
            0f,
            height.toFloat(),
            width.toFloat(),
            height.toFloat(),
            width * 0.3f,
            0f
        )
        canvas.drawLines(points, paint)
    }
}
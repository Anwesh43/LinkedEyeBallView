package com.anwesh.uiprojects.eyeballview

/**
 * Created by anweshmishra on 16/08/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.graphics.RectF
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.content.Context

val nodes : Int = 5
val parts : Int = 4
val sizeFactor : Float = 4.6f
val ballSizeFactor : Float = 4.6f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#BDBDBD")
val backColor : Int = Color.parseColor("#212121")
val rot : Float = 360f
val textSizeFactor : Float = 4.7f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawTextIndex(i : Int, sf : Float, w : Float, h : Float, paint : Paint) {
    paint.color = backColor
    val textSize = Math.min(w, h) / textSizeFactor
    paint.textSize = textSize * sf
    save()
    translate(0f, -h / 2 + textSize)
    rotate(rot * sf)
    drawText("$i", 0f, -textSize / 2, paint)
    restore()
}
fun Canvas.drawEyeBall(i : Int, scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    val sf4 : Float = sf.divideScale(3, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    val r : Float = size / ballSizeFactor
    save()
    translate(w / 2, h / 2)
    drawTextIndex(i, sf, w, h, paint)
    for (j in 0..1) {
        save()
        scale(1f - 2 * j, 1f)
        paint.color = foreColor
        drawCircle(-(w / 2 - size) * sf2, 0f, size * sf1, paint)
        save()
        rotate(rot * sf4)
        paint.color = backColor
        drawCircle(-size * sf3, 0f, r * sf3 , paint)
        restore()
        restore()
    }
    restore()
}

fun Canvas.drawEBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    drawEyeBall(i, scale, w, h, paint)
}

class EyeBallView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}

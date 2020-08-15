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

val nodes : Int = 5
val parts : Int = 4
val sizeFactor : Float = 4.6f
val ballSizeFactor : Float = 4.6f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#BDBDBD")
val backColor : Int = Color.parseColor("#212121")

package com.inandout.real_rider.comm

import android.content.Context
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginStart
import com.inandout.real_rider.R
import com.inandout.real_rider.util.dp2px
import com.inandout.real_rider.util.px2dp


class CommTitleBar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    init {
        inflate(context, R.layout.comm_title_bar, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.comm_title_bar)
        val title = typedArray.getString(R.styleable.comm_title_bar_title) ?: "__VIEW__"
        val titleGravity = typedArray.getString(R.styleable.comm_title_bar_titleGravity) ?: ""

        setTitle(title)
        setTitleGravity(titleGravity)

        typedArray.recycle()
    }

    private fun setTitle(title : String) {
        findViewById<TextView>(R.id.comm_title).setText(title)
    }

    private fun setTitleGravity(gravity : String) {
        if(gravity == "center" ) {
            val commtitle = findViewById<TextView>(R.id.comm_title)
            var layoutParams = commtitle.layoutParams as LayoutParams
            layoutParams.marginStart = 0
            commtitle.layoutParams = layoutParams
        }
    }

    public fun setOnBackButtonListener(onClick : (View) -> Unit) {
        findViewById<ImageView>(R.id.comm_back_button).setOnClickListener {
//            val mp = MediaPlayer.create(this,R.raw.sound) // TODO : sound 추가
//            mp.start()
            onClick(it)
        }
    }
}

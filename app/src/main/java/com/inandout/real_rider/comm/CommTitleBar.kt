package com.inandout.real_rider.comm

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inandout.real_rider.R


class CommTitleBar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    init {
        inflate(context, R.layout.comm_title_bar, this)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.comm_title_bar)
        val title = typedArray.getString(R.styleable.comm_title_bar_title) ?: "__VIEW__"

        setTitle(title)

        typedArray.recycle()
    }

    private fun setTitle(title : String) {
        findViewById<TextView>(R.id.comm_title).setText(title)
    }

    public fun setOnBackButtonListener(onClick : OnClickListener) {
        findViewById<TextView>(R.id.comm_title).setOnClickListener(onClick)
    }
}

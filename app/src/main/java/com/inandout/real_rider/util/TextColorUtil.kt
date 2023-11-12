package com.inandout.real_rider.util

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView

fun changeColorPartOfTextView(textView: TextView, start : Int, end : Int, color : Int = Color.RED) {
    val spannableString = SpannableString(textView.text)
    spannableString.setSpan(ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    textView.text = spannableString
}
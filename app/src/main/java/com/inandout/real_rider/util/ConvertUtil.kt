package com.inandout.real_rider.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

fun dp2px(context : Context, dp: Float): Float {
    val resources: Resources = context.resources
    val metrics = resources.displayMetrics
    return dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun px2dp(context : Context, px: Float): Float {
    val resources: Resources = context.resources
    val metrics = resources.displayMetrics
    return px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

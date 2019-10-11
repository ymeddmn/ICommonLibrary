package com.sitech.paas.common.utils

import android.content.Context

/**
 * author  :mayong
 * function:
 * date    :2019-10-10
 **/

fun dp2px(context: Context, dp: Int): Float {
    val displayMetrics = context.resources.displayMetrics
    return dp * displayMetrics.density
}
package com.exchange.core.ui

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface Resource {

    fun string(@StringRes id: Int): String

    fun stringWithArgs(
        @StringRes id: Int,
        vararg formatArgs: Any?
    ): String

    class Base @Inject constructor(
        private val context: Context
    ) : Resource {
        override fun string(id: Int) =
            context.getString(id)

        override fun stringWithArgs(
            id: Int,
            vararg formatArgs: Any?
        ) = context.getString(id, *formatArgs)
    }
}
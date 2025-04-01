package com.example.prj_trocainfo.util


import java.util.Locale


    fun Int.formatarContador(): String {
        return when {
            this >= 1_000_000 -> "%.1fM".formatLocalized(this / 1_000_000.0).replace(".0", "")
            this >= 1_000 -> "%.1fk".formatLocalized(this / 1_000.0).replace(".0", "")
            else -> this.toString()
        }
    }

    private fun String.formatLocalized(vararg args: Any): String {
        return String.format(Locale.US, this, *args)
    }

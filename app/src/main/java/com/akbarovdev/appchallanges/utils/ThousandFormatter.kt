package com.akbarovdev.appchallanges.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

enum class FormatType {
    Dot, Space, Comma
}

object ThousandFormatter {

    fun thousandFormat(value: Int, type: FormatType): String {
        val symbols = DecimalFormatSymbols(Locale.getDefault())
        symbols.groupingSeparator = when (type) {
            FormatType.Dot -> '.'
            FormatType.Space -> ' '
            FormatType.Comma -> ','
        }

        val formatter = DecimalFormat("#,###", symbols)
        return formatter.format(value)
    }
}

package com.exchange.designsystem.components.keyboard.data


class NumberKeyboardData(
    amount: String,
    private val decimalSeparator: Char,
    private val groupingSeparator: Char,
) {
    private val rawAmount = amount.ifEmpty {
        EMPTY_AMOUNT
    }

    fun value() = rawAmount
        .replace(",", ".")
        .toDoubleOrNull() ?: 0.0

    fun formattedValue(): String {
        val parts = rawAmount.split(decimalSeparator)
        val integerPart = parts[0]
        val decimalPart = if (parts.size > 1) decimalSeparator + parts[1] else ""

        val formattedIntegerPart = StringBuilder()
        var index = 0

        for (i in integerPart.length - 1 downTo 0) {
            formattedIntegerPart.insert(0, integerPart[i])
            index++
            if (index % 3 == 0 && i > 0) {
                formattedIntegerPart.insert(0, groupingSeparator)
            }
        }

        return formattedIntegerPart.toString() + decimalPart
    }

    companion object {
        private const val EMPTY_AMOUNT = "0"
    }
}

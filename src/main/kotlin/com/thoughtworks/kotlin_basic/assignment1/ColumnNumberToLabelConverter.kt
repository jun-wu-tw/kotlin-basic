package com.thoughtworks.kotlin_basic.assignment1

class ColumnNumberToLabelConverter {

  companion object {
    private const val UPPER_LIMIT_COLUMN_NUMBER = 18278

    fun convertToLabel(columnNumber: Int): String {
      return when {
        columnNumber <= 0 -> throw IllegalArgumentException("Column number must be positive and greater than zero")
        columnNumber > UPPER_LIMIT_COLUMN_NUMBER -> throw IllegalArgumentException("Column number must be positive and less than 18279")
        else -> convertValidColumnNumberToLabel(columnNumber)
      }
    }

    private fun convertValidColumnNumberToLabel(columnNumber: Int): String {
      var mutableColumnNumber = columnNumber
      val result = StringBuilder()

      while (mutableColumnNumber > 0) {
        mutableColumnNumber--  // Adjust to 0-based index
        val remainder = mutableColumnNumber % 26
        result.append(('A' + remainder))
        mutableColumnNumber /= 26
      }

      return result.reverse().toString()
    }
  }
}

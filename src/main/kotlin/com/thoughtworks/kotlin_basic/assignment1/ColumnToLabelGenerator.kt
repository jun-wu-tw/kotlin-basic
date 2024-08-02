package com.thoughtworks.kotlin_basic.assignment1

class ColumnToLabelGenerator {

  fun generateColumnNames(startIndexWithNumberOfResult: Pair<Int, Int>): List<String> {
    val (startIndex, numberOfResult) = startIndexWithNumberOfResult

    val result = arrayListOf<String>()
    for (columnNumber in startIndex..<(startIndex + numberOfResult)) {
      result.add(ColumnNumberToLabelConverter.convertToLabel(columnNumber))
    }

    return result
  }
}

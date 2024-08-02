package com.thoughtworks.kotlin_basic.assignment1

import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ColumnToLabelGeneratorTest {

  @Nested
  @DisplayName("when generateColumnNames method is called")
  inner class GenerateColumnNames {

    @Test
    fun `should return ColumnNumberToLabelConverter$convertToLabel values`() {
      val firstColumnName = "A"
      val secondColumnName = "B"

      mockkObject(ColumnNumberToLabelConverter.Companion) {
        // given
        every { ColumnNumberToLabelConverter.convertToLabel(10) } returns firstColumnName
        every { ColumnNumberToLabelConverter.convertToLabel(11) } returns secondColumnName
        // when
        val actualColumnNames = ColumnToLabelGenerator().generateColumnNames(Pair(10, 2))
        // then
        assertEquals(2, actualColumnNames.size)
        assertEquals(firstColumnName, actualColumnNames[0])
        assertEquals(secondColumnName, actualColumnNames[1])
      }
    }
  }
}
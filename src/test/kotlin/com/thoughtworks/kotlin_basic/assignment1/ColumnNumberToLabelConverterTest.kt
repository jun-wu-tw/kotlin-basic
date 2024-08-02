package com.thoughtworks.kotlin_basic.assignment1

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ColumnNumberToLabelConverterTest {

  @Nested
  @DisplayName("when column number is negative")
  internal inner class WhenColumnNumberIsNegative {

    @Test
    fun `should fail with exception`() {
      assertFailsWith(
        exceptionClass = IllegalArgumentException::class,
        message = "Column number must be positive and greater than zero"
      ) {
        ColumnNumberToLabelConverter.convertToLabel(-1)
      }
    }
  }

  @Nested
  @DisplayName("when column number is zero")
  internal inner class WhenColumnNumberIsZero {

    @Test
    fun `should fail with exception`() {
      assertFailsWith(
        exceptionClass = IllegalArgumentException::class,
        message = "Column number must be positive and greater than zero"
      ) {
        ColumnNumberToLabelConverter.convertToLabel(0)
      }
    }
  }

  @Nested
  @DisplayName("when column number is positive and not zero")
  internal inner class WhenColumnNumberIsPositiveAndNotZero {

    @Nested
    @DisplayName("and column number is smaller than 18279")
    internal inner class AndColumnNumberIsSmallerThan18279 {
      @ParameterizedTest(name = "and column number is {0}, should return {1}")
      @CsvSource(
        value = ["1:A", "2:B", "3:C", "4:D", "5:E", "6:F", "7:G", "8:H", "9:I", "10:J", "11:K",
          "12:L", "13:M", "14:N", "15:O", "16:P", "17:Q", "18:R", "19:S", "20:T", "21:U", "22:V",
          "23:W", "24:X", "25:Y", "26:Z", "27:AA", "52:AZ", "677:ZA", "702:ZZ", "703:AAA", "18278:ZZZ"
        ],
        delimiter = ':',
      )
      fun shouldReturnCorrespondingAlphabet(columnNumber: Int, expectedAlphabet: String) {
        assertEquals(expectedAlphabet, ColumnNumberToLabelConverter.convertToLabel(columnNumber))
      }
    }

    @Nested
    @DisplayName("and column number is greater than 18278")
    internal inner class AndColumnNumberIsGreaterThan18278 {

      @Test
      fun `should fail with exception`() {
        assertFailsWith(
          exceptionClass = IllegalArgumentException::class,
          message = "Column number must be positive and less than 18279"
        ) {
          ColumnNumberToLabelConverter.convertToLabel(18279)
        }
      }
    }
  }

}
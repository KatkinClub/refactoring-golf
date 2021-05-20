package tax

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test


class TakeHomeCalculatorTest {
    @Test
    @Throws(Exception::class)
    fun canCalculateTax() {
        val first = TakeHomeCalculator(10).netAmount(
            TakeHomeCalculator.Pair(40, "GBP"),
            TakeHomeCalculator.Pair(50, "GBP"),
            TakeHomeCalculator.Pair(60, "GBP")
        ).first
        assertEquals(135, first.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun cannotSumDifferentCurrencies() {
        assertThrows(Incalculable::class.java) {
            TakeHomeCalculator(10).netAmount(TakeHomeCalculator.Pair(4, "GBP"), TakeHomeCalculator.Pair(5, "USD"))
        }
    }
}
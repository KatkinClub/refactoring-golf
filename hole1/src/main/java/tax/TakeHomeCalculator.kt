package tax

import java.util.*

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(vararg rest: Pair<Double, String>): Pair<Double, String> {

        if (rest.toList().all { it.second != rest[0].second }) {
            throw Incalculable()
        } else {
            var total = 0.0
            rest.forEach { total += it.first }
            val amount = total - (total * percent / 100.0)
            return Pair(amount, rest[0].second)
        }

    }

    internal class Pair<A, B>(val first: A, val second: B)
}

internal class Incalculable : RuntimeException()
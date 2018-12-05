package club.bweakfast.foodora.util

import org.threeten.bp.LocalTime

val beforeMidnight: LocalTime by lazy { LocalTime.of(23, 59) }
val afterMidnight: LocalTime by lazy { LocalTime.of(0, 0) }
val noon: LocalTime by lazy { LocalTime.of(12, 0) }
val evening: LocalTime by lazy { LocalTime.of(18, 0) }

fun getTimeOfDay(): TimeOfDay {
    val currentTime = LocalTime.now().withSecond(0).withNano(0)

    return when {
        currentTime.isAfter(afterMidnight) && (currentTime.isBefore(noon) || currentTime == noon) -> TimeOfDay.MORNING
        currentTime.isAfter(noon) && (currentTime.isBefore(evening) || currentTime == evening) -> TimeOfDay.AFTERNOON
        currentTime.isAfter(evening) && (currentTime.isBefore(beforeMidnight) || currentTime == beforeMidnight) -> TimeOfDay.EVENING
        else -> throw UnsupportedOperationException()
    }
}

enum class TimeOfDay {
    MORNING, AFTERNOON, EVENING
}
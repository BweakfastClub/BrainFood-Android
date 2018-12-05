package club.bweakfast.foodora.util

import java.time.LocalDateTime

val midnight: LocalDateTime by lazy { LocalDateTime.now().withHour(0).withMinute(0) }
val noon: LocalDateTime by lazy { LocalDateTime.now().withHour(12).withMinute(0) }
val evening: LocalDateTime by lazy { LocalDateTime.now().withHour(18).withMinute(0) }
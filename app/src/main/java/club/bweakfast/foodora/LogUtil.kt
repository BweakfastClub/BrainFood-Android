package club.bweakfast.foodora

import android.util.Log

/**
 * Created by silve on 3/26/2018.
 */

fun Any.log(message: String, level: Int = Log.DEBUG) {
    val className = this::class.java.simpleName
    val function: (String, String) -> Int = when (level) {
        Log.VERBOSE -> Log::v
        Log.DEBUG -> Log::d
        Log.INFO -> Log::i
        Log.WARN -> Log::w
        else -> throw IllegalArgumentException("Invalid log priority")
    }
    function.invoke(className, message)
}

fun Any.onError(throwable: Throwable) {
    onError(throwable, null)
}

fun Any.onError(throwable: Throwable, message: String?) {
    Log.e(this::class.java.simpleName, message ?: throwable.message, throwable)
}
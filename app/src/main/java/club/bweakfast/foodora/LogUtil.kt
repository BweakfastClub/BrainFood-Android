package club.bweakfast.foodora

import android.content.Context
import android.util.Log

/**
 * Created by silve on 3/26/2018.
 */

private val defaultToastMessageHandler = { context: Context, _: Throwable ->
    context.getString(R.string.error_occurred)
}

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

fun Any.onError(
    throwable: Throwable,
    context: Context,
    toastMessageHandler: (Context, Throwable) -> String = defaultToastMessageHandler
) {
    val message = toastMessageHandler(context, throwable)
    context.toast(message)
    Log.e(this::class.java.simpleName, message, throwable)
}
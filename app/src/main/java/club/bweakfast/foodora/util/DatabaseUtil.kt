package club.bweakfast.foodora.util

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

fun SQLiteDatabase.insert(table: String, contentValues: ContentValues) = insert(table, null, contentValues)

fun SQLiteDatabase.insertOrThrow(table: String, contentValues: ContentValues) = insertOrThrow(table, null, contentValues)

fun SQLiteDatabase.query(
    table: String,
    columns: Array<String>? = null,
    selection: String? = null,
    selectionArgs: Array<String>? = null,
    groupBy: String? = null,
    having: String? = null,
    orderBy: String? = null
): Cursor {
    return query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
}

inline fun <R> Cursor.map(transform: (Cursor) -> R): List<R> {
    if (!moveToFirst()) {
        return emptyList()
    }

    val list = mutableListOf<R>()
    do {
        list.add(transform(this))
    } while (moveToNext())

    return list
}
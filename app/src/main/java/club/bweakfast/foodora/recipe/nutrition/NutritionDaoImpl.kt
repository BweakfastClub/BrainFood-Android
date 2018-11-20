package club.bweakfast.foodora.recipe.nutrition

import androidx.core.content.contentValuesOf
import androidx.core.database.getInt
import androidx.core.database.sqlite.transaction
import club.bweakfast.foodora.db.COLUMN_NUTRITION_AMOUNT
import club.bweakfast.foodora.db.COLUMN_NUTRITION_COMPLETE_DATA
import club.bweakfast.foodora.db.COLUMN_NUTRITION_DAILY_VALUE
import club.bweakfast.foodora.db.COLUMN_NUTRITION_DISPLAY_VALUE
import club.bweakfast.foodora.db.COLUMN_NUTRITION_ID
import club.bweakfast.foodora.db.COLUMN_NUTRITION_NAME
import club.bweakfast.foodora.db.COLUMN_NUTRITION_UNIT
import club.bweakfast.foodora.db.COLUMN_REL_NUTRITION_ID
import club.bweakfast.foodora.db.COLUMN_REL_RECIPE_ID
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.db.TABLE_NUTRITION_NAME
import club.bweakfast.foodora.db.TABLE_RECIPE_NUTRITION_NAME
import club.bweakfast.foodora.recipe.RecipeDaoImpl
import club.bweakfast.foodora.util.insert
import club.bweakfast.foodora.util.map
import club.bweakfast.foodora.util.query
import club.bweakfast.foodora.util.toInt
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class NutritionDaoImpl @Inject constructor(private val foodoraDB: FoodoraDB) : NutritionDao {
    override fun getNutrition(recipeID: Int): Single<List<NutritionValue>> {
        return Single.create { emitter ->
            val db = foodoraDB.readableDatabase
            val cursor = db.rawQuery(
                """SELECT
                    |n.$COLUMN_NUTRITION_ID,
                    |n.$COLUMN_NUTRITION_AMOUNT,
                    |n.$COLUMN_NUTRITION_UNIT,
                    |n.$COLUMN_NUTRITION_DISPLAY_VALUE,
                    |n.$COLUMN_NUTRITION_DAILY_VALUE,
                    |n.$COLUMN_NUTRITION_COMPLETE_DATA
                    |FROM $TABLE_NUTRITION_NAME n
                    |JOIN $TABLE_RECIPE_NUTRITION_NAME rn ON n.$COLUMN_NUTRITION_ID = rn.$COLUMN_REL_NUTRITION_ID
                    |WHERE n.$COLUMN_NUTRITION_ID = ?;""".trimMargin(),
                arrayOf(recipeID.toString())
            )

//            cursor.use { emitter.onSuccess(it.map { NutritionValue.createFromCursor(it) }) }
        }
    }

    override fun saveNutrition(nutrition: List<NutritionValue>, recipeID: Int): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.transaction {
                nutrition.forEach {
                    db.insert(
                        TABLE_NUTRITION_NAME,
                        contentValuesOf(
                            COLUMN_NUTRITION_NAME to it.name,
                            COLUMN_NUTRITION_AMOUNT to it.amount,
                            COLUMN_NUTRITION_UNIT to it.unit,
                            COLUMN_NUTRITION_DISPLAY_VALUE to it.displayValue,
                            COLUMN_NUTRITION_DAILY_VALUE to it.dailyValue,
                            COLUMN_NUTRITION_COMPLETE_DATA to it.isCompleteData.toInt()
                        )
                    )

                    val getNullableWhere = { column: String, value: String? -> value?.let { "$column = ?" } ?: "$column IS NULL" }
                    val selection =
                        "$COLUMN_NUTRITION_NAME = ? AND $COLUMN_NUTRITION_AMOUNT = ? AND ${getNullableWhere(COLUMN_NUTRITION_UNIT, it.unit)} AND ${getNullableWhere(
                            COLUMN_NUTRITION_DISPLAY_VALUE, it.displayValue
                        )} AND ${getNullableWhere(
                            COLUMN_NUTRITION_DAILY_VALUE, it.dailyValue
                        )} AND $COLUMN_NUTRITION_COMPLETE_DATA = ?"

                    val selectionArgs = mutableListOf(it.name, it.amount.toString())
                    val nullableArgs = listOf(it.unit, it.displayValue, it.dailyValue)
                    nullableArgs.forEach { it?.let { selectionArgs.add(it) } }
                    selectionArgs.add(it.isCompleteData.toInt().toString())

                    val cursor = db.query(
                        TABLE_NUTRITION_NAME,
                        arrayOf(COLUMN_NUTRITION_ID),
                        selection,
                        selectionArgs.toTypedArray()
                    )
                    val nutritionID = cursor.use { it.getInt(COLUMN_NUTRITION_ID) }

                    db.insert(
                        TABLE_RECIPE_NUTRITION_NAME,
                        contentValuesOf(
                            COLUMN_REL_RECIPE_ID to recipeID,
                            COLUMN_REL_NUTRITION_ID to nutritionID
                        )
                    )
                }
            }
            it.onComplete()
        }
    }

    override fun deleteNutrition(recipeID: Int): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
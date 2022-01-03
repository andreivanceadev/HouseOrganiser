package com.andreivanceadev.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.andreivanceadev.storage.dao.RecipeDao
import com.andreivanceadev.storage.entities.recipes.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class
    ],
    version = 1, exportSchema = false
)
@TypeConverters(DBTypeConverters::class)
abstract class KitchenOrganiserDatabase : RoomDatabase() {

    abstract val recipeDao: RecipeDao

    companion object {

        private const val DATABASE_NAME = "kitchenDB"

        @Synchronized
        fun getDatabase(context: Context): KitchenOrganiserDatabase {
            return Room.databaseBuilder(context, KitchenOrganiserDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}

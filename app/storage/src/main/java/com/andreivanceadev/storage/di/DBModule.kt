package com.andreivanceadev.storage.di

import android.content.Context
import com.andreivanceadev.storage.KitchenOrganiserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) = KitchenOrganiserDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideRecipeDao(database: KitchenOrganiserDatabase) = database.recipeDao

    @Provides
    @Singleton
    fun provideAppContext(@ApplicationContext context: Context) = context
}

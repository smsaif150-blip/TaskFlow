package com.example.to_dolistapp.di

import android.content.Context
import androidx.room.Room
import com.example.to_dolistapp.data.local.dao.TaskDataDao
import com.example.to_dolistapp.data.local.database.TaskAppData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TaskAppData
    {

        return Room.databaseBuilder(
            context.applicationContext,
            TaskAppData::class.java,
            "task_database.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: TaskAppData): TaskDataDao
    {
        return database.taskDataDao()
    }

}
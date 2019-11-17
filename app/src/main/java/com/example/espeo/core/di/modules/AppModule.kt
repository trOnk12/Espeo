package com.example.espeo.core.di.modules

import android.content.Context
import com.example.espeo.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: AndroidApplication) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = application

}
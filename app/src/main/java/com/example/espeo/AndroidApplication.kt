package com.example.espeo

import android.app.Application
import com.example.espeo.core.di.ApplicationComponent
import com.example.espeo.core.di.DaggerApplicationComponent
import com.example.espeo.core.di.modules.AppModule

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}
package com.example.espeo.core.di

import com.example.espeo.AndroidApplication
import com.example.espeo.core.di.modules.AppModule
import com.example.espeo.core.di.modules.NetworkModule
import com.example.espeo.core.di.modules.RepositoryModule
import com.example.espeo.domain.model.Student
import dagger.Component
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)

}
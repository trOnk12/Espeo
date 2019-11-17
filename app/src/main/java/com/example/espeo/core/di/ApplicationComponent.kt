package com.example.espeo.core.di

import com.example.espeo.AndroidApplication
import com.example.espeo.core.di.modules.AppModule
import com.example.espeo.core.di.modules.NetworkModule
import com.example.espeo.core.di.modules.RepositoryModule
import com.example.espeo.core.di.viewmodel.ViewModelModule
import com.example.espeo.feature.presentation.StudentListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(studentListActivity: StudentListActivity)
}
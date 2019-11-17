package com.example.espeo.core.platform

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.espeo.AndroidApplication
import com.example.espeo.core.di.ApplicationComponent
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as AndroidApplication).appComponent
    }

}
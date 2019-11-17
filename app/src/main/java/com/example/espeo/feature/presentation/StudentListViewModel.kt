package com.example.espeo.feature.presentation

import androidx.lifecycle.MutableLiveData
import com.example.espeo.core.platform.BaseViewModel
import com.example.espeo.feature.domain.model.Student
import com.example.espeo.feature.domain.usecase.GetStudents
import com.example.espeo.feature.presentation.model.StudentItem
import com.example.espeo.feature.presentation.model.mapToPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StudentListViewModel
@Inject constructor(
    private val getStudents: GetStudents
) : BaseViewModel() {

     val studentList: MutableLiveData<List<StudentItem>> = MutableLiveData()

    fun getStudents() {
        compositeDisposable.add(
            getStudents.invoke()
                .subscribeOn(Schedulers.io())
                .map { it.mapToPresentation() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { students -> studentList.value = students }
        )
    }

}
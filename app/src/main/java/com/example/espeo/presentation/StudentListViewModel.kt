package com.example.espeo.presentation

import androidx.lifecycle.MutableLiveData
import com.example.espeo.core.platform.BaseViewModel
import com.example.espeo.domain.model.Student
import com.example.espeo.domain.usecase.GetStudents
import io.reactivex.schedulers.Schedulers

class StudentListViewModel(private val getStudents: GetStudents) : BaseViewModel() {

    private val studentListLiveData: MutableLiveData<List<Student>> = MutableLiveData()

    fun getStudents() {
        compositeDisposable.add(
            getStudents.invoke().subscribeOn(Schedulers.io())
                .subscribe { studentList -> studentListLiveData.value = studentList }
        )
    }


}
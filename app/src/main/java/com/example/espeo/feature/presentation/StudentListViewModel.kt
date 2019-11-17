package com.example.espeo.feature.presentation

import androidx.lifecycle.MutableLiveData
import com.example.espeo.core.platform.BaseViewModel
import com.example.espeo.feature.domain.model.Student
import com.example.espeo.feature.domain.usecase.GetStudents
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StudentListViewModel
@Inject constructor(
    private val getStudents: GetStudents
) : BaseViewModel() {

     val studentList: MutableLiveData<List<Student>> = MutableLiveData()

    fun getStudents() {
        compositeDisposable.add(
            getStudents.invoke().subscribeOn(Schedulers.io())
                .subscribe { students -> studentList.value = students }
        )
    }

}
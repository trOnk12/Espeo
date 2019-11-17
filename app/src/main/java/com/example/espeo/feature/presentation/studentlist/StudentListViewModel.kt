package com.example.espeo.feature.presentation.studentlist

import androidx.lifecycle.MutableLiveData
import com.example.espeo.core.extension.setError
import com.example.espeo.core.extension.setLoading
import com.example.espeo.core.extension.setSuccess
import com.example.espeo.core.functional.Resource
import com.example.espeo.core.platform.BaseViewModel
import com.example.espeo.feature.domain.usecase.GetStudents
import com.example.espeo.feature.presentation.model.StudentItem
import com.example.espeo.feature.presentation.model.mapToPresentation
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StudentListViewModel
@Inject constructor(
    private val getStudents: GetStudents
) : BaseViewModel() {

    val studentList: MutableLiveData<Resource<List<StudentItem>>> = MutableLiveData()

    fun getStudents() {
        compositeDisposable.add(
            getStudents.invoke()
                .doOnSubscribe { studentList.setLoading() }
                .subscribeOn(Schedulers.io())
                .map { it.mapToPresentation() }
                .subscribe({ studentList.setSuccess(it) }, { studentList.setError(it.message) })
        )
    }

}
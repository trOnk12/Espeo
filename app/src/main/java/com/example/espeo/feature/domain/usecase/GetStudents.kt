package com.example.espeo.feature.domain.usecase

import com.example.espeo.feature.domain.model.Student
import com.example.espeo.feature.domain.repository.StudentRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetStudents
@Inject constructor(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(): Single<List<Student>> = studentRepository.getStudents()
        .toObservable()
        .flatMap { studentList -> Observable.fromIterable(studentList) }
        .distinct()
        .toList()
}
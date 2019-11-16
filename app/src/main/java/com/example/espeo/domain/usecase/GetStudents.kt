package com.example.espeo.domain.usecase

import com.example.espeo.domain.repository.StudentRepository

class GetStudents(private val studentRepository: StudentRepository) {
    operator fun invoke() = studentRepository.getStudents()
}
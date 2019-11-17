package com.example.espeo.feature.presentation.model

import com.example.espeo.feature.domain.model.AgeStatus
import com.example.espeo.feature.domain.model.Student

data class StudentItem(
    val name: String,
    val studentStatus: String,
    val majorityStatus: String
)

fun List<Student>.mapToPresentation(): List<StudentItem> =
    map { StudentItem(it.name, determineStudentStatus(it.isStudent), determineMajority(it.ageStatus)) }

private fun determineMajority(ageStatus: AgeStatus): String {
    return when (ageStatus) {
        AgeStatus.IS_UNDERAGE -> "Not adult"
        AgeStatus.IS_NOT_UNDERAGE -> "Adult"
    }
}

private fun determineStudentStatus(student: Boolean): String {
    return if (student) "Student" else "Not Student"
}

package com.example.espeo.feature.presentation.model

import com.example.espeo.feature.domain.model.AgeStatus
import com.example.espeo.feature.domain.model.Student

data class StudentItem(
    val name: String,
    val studentStatus: String,
    val majorityStatus: String
) {
    override fun equals(other: Any?): Boolean {
        if (other == this) return true
        if (other !is StudentItem) return false

        val studentItem: StudentItem = other

        return (studentItem.equals(name))
    }

    override fun hashCode(): Int {
        return 0
    }

}

fun List<Student>.mapToPresentation(): List<StudentItem> =
    map { StudentItem(it.name, determineStudentStatus(it.isStudent), determineMajority(it.ageStatus)) }

private fun determineMajority(ageStatus: AgeStatus): String {
    return when (ageStatus) {
        AgeStatus.IS_UNDERAGE -> "not adult"
        AgeStatus.IS_NOT_UNDERAGE -> "adult"
    }
}

private fun determineStudentStatus(student: Boolean): String {
    return if (student) "student" else "not student"
}

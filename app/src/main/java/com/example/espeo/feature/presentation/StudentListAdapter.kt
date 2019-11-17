package com.example.espeo.feature.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.espeo.R
import com.example.espeo.feature.domain.model.Student
import kotlin.properties.Delegates

class StudentListAdapter : RecyclerView.Adapter<StudentListAdapter.ViewHolder>() {

    var studentList: List<Student> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bikeStationView = inflater.inflate(R.layout.student_list_item, parent, false)

        return ViewHolder(bikeStationView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(studentList[position])

    override fun getItemCount() = studentList.size

    class ViewHolder(studentView: View) : RecyclerView.ViewHolder(studentView) {

        fun bind(student: Student) {
            with(student) {
            }
        }
    }

}
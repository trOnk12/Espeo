package com.example.espeo.feature.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.espeo.R
import com.example.espeo.feature.domain.model.AgeStatus
import com.example.espeo.feature.domain.model.Student
import com.example.espeo.feature.presentation.model.StudentItem
import kotlin.properties.Delegates
import kotlinx.android.synthetic.main.student_list_item.view.*
import javax.inject.Inject

class StudentListAdapter
@Inject constructor() : RecyclerView.Adapter<StudentListAdapter.ViewHolder>() {

    var studentList: List<StudentItem> by Delegates.observable(emptyList()) { _, _, _ ->
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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(studentItem: StudentItem) {
            with(studentItem) {
                itemView.name.text = "Student name : $name"
                itemView.status.text = "Student status :  $studentStatus"
                itemView.majority.text = "Student majority : $majorityStatus"
            }
        }
    }

}
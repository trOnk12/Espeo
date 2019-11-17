package com.example.espeo.feature.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.espeo.R
import com.example.espeo.feature.presentation.model.StudentItem
import kotlinx.android.synthetic.main.student_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

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
                itemView.name.text = itemView.context.resources.getString(R.string.student_name, name)
                itemView.status.text = itemView.context.resources.getString(R.string.student_status, studentStatus)
                itemView.majority.text = itemView.context.resources.getString(R.string.student_majority, majorityStatus)
            }
        }
    }

}
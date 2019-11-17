package com.example.espeo.feature.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.espeo.R
import com.example.espeo.core.extension.startRefreshing
import com.example.espeo.core.extension.stopRefreshing
import com.example.espeo.core.functional.Resource
import com.example.espeo.core.functional.ResourceState
import com.example.espeo.core.platform.BaseActivity
import com.example.espeo.feature.presentation.model.StudentItem
import kotlinx.android.synthetic.main.student_list_activity.*
import javax.inject.Inject

class StudentListActivity : BaseActivity() {

    @Inject
    lateinit var studentListAdapter: StudentListAdapter
    lateinit var studentListViewModel: StudentListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_list_activity)
        appComponent.inject(this)

        initializeView()

        if (savedInstanceState == null) {
            studentListViewModel.getStudents()
        }

    }

    private fun initializeView() {
        studentListView.adapter = studentListAdapter
        swipeRefreshLayout.setOnRefreshListener { studentListViewModel.getStudents() }

        studentListViewModel = ViewModelProviders
            .of(this, viewModelFactory)[StudentListViewModel::class.java]

        studentListViewModel.studentList.observe(this, Observer(::showStudentList))
    }

    private fun showStudentList(resource: Resource<List<StudentItem>>?) {
        resource?.let {
            when (resource.state) {
                ResourceState.SUCCESS, ResourceState.ERROR -> swipeRefreshLayout.stopRefreshing()
                ResourceState.LOADING -> swipeRefreshLayout.startRefreshing()
            }
            it.data?.let { studentList ->
                studentListAdapter.studentList = studentList
            }
            it.message?.let { message -> showToast(message) }
        }
    }

}

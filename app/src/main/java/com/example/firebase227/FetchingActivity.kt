package com.example.firebase227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class FetchingActivity : AppCompatActivity() {
    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView

    //    private lateinit var empList:ArrayList<EmployeeModel>
    private lateinit var stList: ArrayList<StudentModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)





        empRecyclerView = findViewById(R.id.fetchRecyclerView)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
//        empRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

//        empList= arrayListOf<EmployeeModel>()
        stList = arrayListOf<StudentModel>()


            getStudentsData()




    }

//    private fun getEmployeesData() {
//
//        dbRef=FirebaseDatabase.getInstance().getReference("Employees")
//        dbRef.addValueEventListener(object :ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//              empList.clear()
//                if(snapshot.exists()){
//                    for(empSnap in snapshot.children){
//                        val empData = empSnap
//                            .getValue(EmployeeModel::class.java)
//                        empList.add(empData!!)
//                    }
//                    val mAdapter = FetchAdapter(empList)
//                    empRecyclerView.adapter=mAdapter
//                    mAdapter.setOnItemClickListener(object :
//                    FetchAdapter.onItemClickListener{
//                        override fun onItemClick(position: Int) {
//                            val intent= Intent(this@FetchingActivity,EmployeeDetailsActivity::class.java)
//                            intent.putExtra("empId", empList[position].empId)
//                            intent.putExtra("empName", empList[position].empName)
//                            intent.putExtra("empAge", empList[position].empAge)
//                            intent.putExtra("empSalary", empList[position].empSalary)
//                            startActivity(intent)
//                        }
//
//                    })
//
//                    empRecyclerView.visibility = View.VISIBLE
//                    tvLoadingData.visibility = View.GONE
//                }
//            }
//
//
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//
//
//    })}


    private fun getStudentsData() {





        dbRef = FirebaseDatabase.getInstance().getReference("Student")


            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    stList.clear()
                    if (snapshot.exists()) {
                        for (stSnap in snapshot.children) {
                            val stData = stSnap
                                .getValue(StudentModel::class.java)
                            stList.add(stData!!)
                        }

                        try {
                            val mAdapter = StudentFetchAdapter(stList)


                            empRecyclerView.adapter = mAdapter
                            empRecyclerView.visibility = View.VISIBLE
                            tvLoadingData.visibility = View.GONE
                        }

                    catch (e:Exception)
                    {
                       tvLoadingData.setText(e.message)
                    }



                    }
                }


                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })
        }




}
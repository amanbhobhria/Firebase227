package com.example.firebase227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EmployeeDetailsActivity : AppCompatActivity() {

    private lateinit var tvEmpID : TextView
    private lateinit var tvEmpName : TextView
    private lateinit var tvEmpAge : TextView
    private lateinit var tvEmpSalary : TextView
    private lateinit var btnUpdate : Button
    private lateinit var btnDelete : Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        tvEmpID = findViewById(R.id.tvEmpId)
        tvEmpName = findViewById(R.id.tvEmpName)
        tvEmpAge = findViewById(R.id.tvEmpAge)
        tvEmpSalary = findViewById(R.id.tvEmpSalary)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)


            setValuesToViews()


        btnUpdate.setOnClickListener {
            val intent = Intent(this@EmployeeDetailsActivity, EmployeeDetailsUpdate::class.java)

            intent.putExtra("empId", tvEmpID.text.toString())
            intent.putExtra("empName", tvEmpName.text.toString())
            intent.putExtra("empAge", tvEmpAge.text.toString())
            intent.putExtra("empSalary", tvEmpSalary.text.toString())
            startActivity(intent)


        }

    }


private fun setValuesToViews(){
    tvEmpID.text=intent.getStringExtra("empId")
    tvEmpName.text=intent.getStringExtra("empName")
    tvEmpAge.text=intent.getStringExtra("empAge")
    tvEmpSalary.text=intent.getStringExtra("empSalary")

}



}

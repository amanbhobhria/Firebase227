package com.example.firebase227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EmployeeDetailsUpdate : AppCompatActivity() {
    private lateinit var tvEmpID : TextView
    private lateinit var tvEmpName : TextView
    private lateinit var tvEmpAge : TextView
    private lateinit var tvEmpSalary : TextView
    private lateinit var btnUpdate : Button

    private lateinit var name:String
    private lateinit var age:String
    private lateinit var salary:String


    private lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details_update)

        tvEmpID = findViewById(R.id.tvEmpId1)
        tvEmpName = findViewById(R.id.tvEmpName1)
        tvEmpAge = findViewById(R.id.tvEmpAge1)
        tvEmpSalary = findViewById(R.id.tvEmpSalary1)
        btnUpdate = findViewById(R.id.btnUpdate1)


        btnUpdate.setOnClickListener {
            name=tvEmpName.text.toString()
            age=tvEmpAge.text.toString()
            salary=tvEmpSalary.text.toString()


            Toast.makeText(this,"hello"+tvEmpID.text.toString(),Toast.LENGTH_LONG).show()
            updateEmpData(tvEmpID.text.toString(),name,age,salary)
            

        }
        setValuesToViews()



    }

    private fun updateEmpData(tvEmpId: String, name: String, age: String, salary: String) {

        dbRef=FirebaseDatabase.getInstance().getReference("Employees")
        var empInfo = EmployeeModel(tvEmpId,name,age,salary)
        dbRef.child(tvEmpId).setValue(empInfo).addOnSuccessListener {
            Toast.makeText(this, "Data updated successfully", Toast.LENGTH_LONG).show()

            val intent = Intent(this@EmployeeDetailsUpdate,LoginBasic::class.java)

        }
            .addOnFailureListener{
                error->
                Toast.makeText(this, "Deleting Error ${error.message}", Toast.LENGTH_LONG).show()
            }



    }


    private fun setValuesToViews(){
        tvEmpID.text=intent.getStringExtra("empId")
        tvEmpName.text=intent.getStringExtra("empName")
        tvEmpAge.text=intent.getStringExtra("empAge")
        tvEmpSalary.text=intent.getStringExtra("empSalary")



    }


}
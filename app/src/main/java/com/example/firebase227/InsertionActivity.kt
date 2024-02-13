package com.example.firebase227

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class InsertionActivity : AppCompatActivity() {
//    private lateinit var etEmpName: EditText
//    private lateinit var etEmpAge: EditText
//    private lateinit var etEmpSalary: EditText


    private lateinit var stRegno: EditText
    private lateinit var stName: EditText
    private lateinit var stStream: EditText
    private lateinit var stLastQ: EditText
    private lateinit var btnSaveData: Button
    private lateinit var btnShowData: Button

    private lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)
        FirebaseApp.initializeApp(this)

        dbRef = FirebaseDatabase.getInstance().getReference("Student")

//        etEmpName = findViewById(R.id.etEmpName)
//        etEmpAge = findViewById(R.id.etEmpAge)
//        etEmpSalary = findViewById(R.id.etEmpSalary)


      stRegno = findViewById(R.id.stRegno)
      stName = findViewById(R.id.stName)
      stStream = findViewById(R.id.stStream)
      stLastQ = findViewById(R.id.stLast)



        btnSaveData = findViewById(R.id.btnSave)



            btnSaveData.setOnClickListener {
                try {
                    saveStudentData()
                }
                catch (e:Exception)
                {
                    Toast.makeText(this, "Error ${e.message}", Toast.LENGTH_LONG).show()
                }
            }


        btnShowData = findViewById(R.id.btnShowData)

        btnShowData.setOnClickListener {

            val intent = Intent(this, FetchingActivity::class.java)
            startActivity(intent)
        }


    }

    private fun saveStudentData() {

//getting values
//           val empName = etEmpName.text.toString()
//        val empAge = etEmpAge.text.toString()
//        val empSalary = etEmpSalary.text.toString()
//
//        if (empName.isEmpty()) {
//            etEmpName.error = "Please enter name"
//        }
//        if (empAge.isEmpty()) {
//            etEmpAge.error = "Please enter age"
//        }
//        if (empSalary.isEmpty()) {
//            etEmpSalary.error = "Please enter salary"
//        }


        val stNam = stName.text.toString()
        val stRegn= stRegno.text.toString()
        val stStrea= stStream.text.toString()
        val stLastQu= stLastQ.text.toString()





        if (stNam.isEmpty()) {
            stName.error = "Please enter name"
        }
        if (stRegn.isEmpty()) {
            stRegno.error = "Please enter Regno"
        }
        if (stStrea.isEmpty()) {
            stStream.error = "Please enter stream"
        }






        val studentId = dbRef.push().key!!

//        val employee = EmployeeModel(studentId, stNam, stRegn, stStrea,stLastQu)
        val student = StudentModel(studentId, stNam, stRegn, stStrea,stLastQu)

        dbRef.child(studentId).setValue(student)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                stName.text.clear()
                stStream.text.clear()
                stRegno.text.clear()
                stLastQ.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }

    }

}
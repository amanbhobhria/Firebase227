package com.example.firebase227

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class RealTimeDatabaseDemo : AppCompatActivity() {
    lateinit var df:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_time_database_demo)

        df=Firebase.database.reference
        df.child("User").setValue("Aman")
        df.child("Person").child("contact num").setValue("1234");
        df.child("Person").child("contact num").
                child("personal num").setValue("123245678")
        df.child("Person").child("contact num").
                child("official num").setValue("399238091")



    }
}
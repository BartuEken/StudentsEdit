package com.example.kaganbartueken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kaganbartueken.StudentsDatabaseHelper
import com.example.kaganbartueken.databinding.ActivityAddStudentBinding

class AddStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var db: StudentsDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = StudentsDatabaseHelper(this)

        binding.addStudent.setOnClickListener {
            val title = binding.nameEditText.text.toString()
            val content = binding.surnameEditText.text.toString()
            val note = Student(0, title, content)
            db.insertStudents(note)
            finish()
            Toast.makeText(this, "Student Saved", Toast.LENGTH_LONG).show()
        }
    }
}



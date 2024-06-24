package com.example.kaganbartueken

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kaganbartueken.R

class StudentAdapter(private var students: List<Student>, context: Context) :
    RecyclerView.Adapter<StudentAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val surnameTextView: TextView = itemView.findViewById(R.id.surnameTextView)
        val deleteButton: Button = itemView.findViewById(R.id.btndlt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val student = students[position]
        holder.nameTextView.text = student.name
        holder.surnameTextView.text = student.surname
        holder.deleteButton.setOnClickListener{
            val db = StudentsDatabaseHelper (it.getContext())
            db.deleteStudent(student)
            refreshData(db.getAllStudents())
        }
    }

    fun refreshData(newNotes: List<Student>) {
        students = newNotes
        notifyDataSetChanged()
    }


}
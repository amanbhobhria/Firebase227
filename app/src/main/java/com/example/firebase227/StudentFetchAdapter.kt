package com.example.firebase227

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentFetchAdapter (private val stList: ArrayList<StudentModel>) :
    RecyclerView.Adapter<StudentFetchAdapter.ViewHolder>() {
    private  var mListener: onItemClickListener ? = null
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_item, parent, false)
        return ViewHolder(itemView, mListener)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val currentSt = stList[position]
            holder.tvStudentName.text = currentSt.stName
            holder.tvStudentId.text = currentSt.stId
            holder.tvStudentRegno.text = currentSt.stRegno
            holder.tvStudentStream.text = currentSt.stStream
            holder.tvStudentLastQual.text = currentSt.stLastQ





    }

    override fun getItemCount(): Int {
        return stList.size
    }

    class ViewHolder(itemView: View, clickListener: onItemClickListener?)
        : RecyclerView.ViewHolder(itemView) {

        val tvStudentName : TextView = itemView.findViewById(R.id.tvStudentName)
        val tvStudentId : TextView = itemView.findViewById(R.id.tvStudentId)
        val tvStudentRegno : TextView = itemView.findViewById(R.id.tvStudentRegno)
        val tvStudentStream : TextView = itemView.findViewById(R.id.tvStudentStream)
        val tvStudentLastQual : TextView = itemView.findViewById(R.id.tvStudentLastQualification)

        init {
//            itemView.setOnClickListener {
//                clickListener.onItemClick(adapterPosition)
                itemView.setOnClickListener {
                    clickListener?.onItemClick(adapterPosition)
            }
        }

    }

}
package com.example.retrofits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(var courseList:List<Courses>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.courses_list_item,parent,false)
        return  CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.tvCode.text=currentCourse.CourseCode
        holder.tvCourseName.text=currentCourse.CourseName
        holder.tvName.text=currentCourse.Instructor
        holder.tvdescription.text=currentCourse.CourseDescription
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvCode=itemView.findViewById<TextView>(R.id.tvCode)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvdecription)
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvcourseName)
}
package com.example.internshipproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class HobbiesActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        val LayoutManager = LinearLayoutManager(this)
        LayoutManager.orientation = LinearLayoutManager.VERTICAL
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LayoutManager
        val adapter = HobbiesAdapter(this,Supplier.hobbies)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
    }
}
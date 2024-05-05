package com.example.audiodownload

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var audioList = listOf(audioData("zombie","https://www.youtube.com/watch?v=DY34c5mEL5Q&list=RDDY34c5mEL5Q&start_radio=1"),
            audioData("in the end","https://www.youtube.com/watch?v=eVTXPUF4Oz4&list=RDDY34c5mEL5Q&index=2"))
        var recycler:RecyclerView = findViewById(R.id.recy)

        var adapter = audioAdapter(this,audioList)



        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)


    }
    fun download(){


    }
}
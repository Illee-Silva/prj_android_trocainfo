package com.example.prj_trocainfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity2: BaseClass(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setupButtonListeners()

        findViewById<Button>(R.id.btn_nextPage).setOnClickListener{
            startActivity(Intent(this, MainActivity3::class.java))
        }

        findViewById<Button>(R.id.btn_backPage).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}
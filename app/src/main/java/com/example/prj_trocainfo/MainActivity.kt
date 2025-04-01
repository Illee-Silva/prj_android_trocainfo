package com.example.prj_trocainfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity: BaseClass(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButtonListeners()

        findViewById<Button>(R.id.btn_nextPage).setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

    }

}
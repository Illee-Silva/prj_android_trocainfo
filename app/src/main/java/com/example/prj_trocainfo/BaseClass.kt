package com.example.prj_trocainfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import com.example.prj_trocainfo.util.formatarContador

abstract class BaseClass: AppCompatActivity() {

    protected var incrementHandler: Handler? = null
    protected var decrementHandler: Handler? = null

    private val incrementRunnable = object: Runnable{
        override  fun run(){
            GlobalCounter.increment()
            incrementHandler?.postDelayed(this, 10)
        }
    }

    private val decrementRunnable = object : Runnable {
        override fun run() {
            GlobalCounter.decrement()
            decrementHandler?.postDelayed(this, 10)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalCounter.count.observe(this) { count ->

            val valorFormatado = count?.formatarContador() ?: "0"
            findViewById<TextView>(R.id.counter).text = valorFormatado
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    protected fun setupButtonListeners() {
        findViewById<Button>(R.id.btn_increase).setOnClickListener {
            GlobalCounter.increment()
        }

        findViewById<Button>(R.id.btn_decrease).setOnClickListener {
            GlobalCounter.decrement()
        }

        findViewById<Button>(R.id.btn_increase).setOnLongClickListener {
            incrementHandler = Handler(Looper.getMainLooper())
            incrementHandler?.post(incrementRunnable)
            true
        }

        findViewById<Button>(R.id.btn_decrease).setOnLongClickListener {
            decrementHandler = Handler(Looper.getMainLooper())
            decrementHandler?.post(decrementRunnable)
            true
        }

        findViewById<Button>(R.id.btn_increase).setOnTouchListener{_, event ->
            if(event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL){
                incrementHandler?.removeCallbacks(incrementRunnable)
            }
            false
        }

        findViewById<Button>(R.id.btn_decrease).setOnTouchListener{_, event ->
            if(event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL){
                decrementHandler?.removeCallbacks(decrementRunnable)
            }
            false
        }

    }

}
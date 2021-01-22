package com.dscuos.timervsdelay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private val mHandler = Handler(Looper.getMainLooper())
    private var startTime: Long = 0L
    private var endTime: Long = 0L
    private var timer: Timer? = null
    private val mRunnable = Runnable {
        println("Runnable")
        endTime = System.currentTimeMillis()
        println(((endTime-startTime)).toString())
    }
    private var coroutineJob: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startTime = System.currentTimeMillis()

        for (i in 1..10000) {
            // Case1. postDelayed
//            mHandler.removeCallbacks(mRunnable)
//            mHandler.postDelayed(mRunnable,2000)

            // Case2. Timer
            timer?.cancel()
            timer = Timer()
            timer?.schedule(2000) {
                println("Timer")
                endTime = System.currentTimeMillis()
                println(((endTime-startTime)).toString())
            }

            // Case3. Coroutine
//            coroutineJob?.cancel()
//            coroutineJob = GlobalScope.launch {
//                delay(2000)
//                println("Coroutine")
//                endTime = System.currentTimeMillis()
//                println(((endTime-startTime)).toString())
//            }
        }
    }
}
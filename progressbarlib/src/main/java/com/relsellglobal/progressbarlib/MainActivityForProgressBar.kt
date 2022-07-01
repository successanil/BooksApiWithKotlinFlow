package com.relsellglobal.progressbarlib

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivityForProgressBar : AppCompatActivity() {
    //private lateinit var binding : ProgressLayoutCircularBinding
    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.setContentView(this@MainActivityForProgressBar,R.layout.progress_layout_circular)

//        // set the id for the progressbar and progress text
//        progressBar = binding.progressBar
//        progressText = binding.progressText
//        val handler = Handler(Looper.myLooper()!!)
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                // set the limitations for the numeric
//                // text under the progress bar
//                if (i <= 100) {
//                    progressText?.setText("" + i)
//                    progressBar?.setProgress(i)
//                    i++
//                    handler.postDelayed(this, 200)
//                } else {
//                    handler.removeCallbacks(this)
//                }
//            }
//        }, 200)
    }
}
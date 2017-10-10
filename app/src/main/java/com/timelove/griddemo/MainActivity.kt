package com.timelove.griddemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun skip() {
        val intent = Intent(this, GridActivity::class.java)
        intent.putExtra("action","传递到位")
        startActivity(intent)
    }
}

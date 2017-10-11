package com.timelove.griddemo

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_one.setOnClickListener(this@MainActivity)
        tv_two.setOnClickListener(this@MainActivity)


    }

    override fun onClick(view: View) {
        val id = view.id
        when (id) {
            R.id.tv_one -> {
                navigate<GridActivity>("action", "one")
            }
            R.id.tv_two -> {
                navigate<GridActivity>("action", "two")
            }
            else -> {
            }
        }
    }

    class data {
        var x: Int? = null
        var y: Int? = null
        var xn: Int? = null
        var yn: Int? = null
    }

}

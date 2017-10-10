package com.timelove.griddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.GridLayout

class GridActivity : AppCompatActivity() {

    private var height = 0   //屏幕高度
    private var width = 0   //屏幕宽度
    private var mainX = 4        //x轴格子数
    private var mainY = 3        //Y轴格子数

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        //获取手机屏幕高宽度
        val wm: WindowManager = this.windowManager
        height = wm.defaultDisplay.height
        width = wm.defaultDisplay.width


//        tab_layout.
    }

    fun setSpanRowCol(grid: GridLayout, t: FrameLayout, x: Int, y: Int, xn: Int, yn: Int) {

        val par = GridLayout.LayoutParams()

        par.rowSpec = GridLayout.spec(y, yn)
        par.columnSpec = GridLayout.spec(Integer.valueOf(x)!!, Integer.valueOf(xn)!!)
        par.height = height / mainY * yn
        par.width = width / mainX * xn
    }

}

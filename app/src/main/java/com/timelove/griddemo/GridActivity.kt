package com.timelove.griddemo

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_grid.*

class GridActivity : BaseActivity() {

    private var height = 0   //屏幕高度
    private var width = 0   //屏幕宽度
    private var mainX = 3       //x轴格子数
    private var mainY = 4        //Y轴格子数
    private var fragmentLayouts: ArrayList<FrameLayout>? = null

    var str: String? = null
    var listone: ArrayList<Data>? = null
    var listtwo: ArrayList<Data>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_grid)

        listone = ArrayList()
        listone?.add(Data(0, 0, 3, 2))
        listone?.add(Data(0, 2, 3, 2))

        listtwo = ArrayList()
        listtwo?.add(Data(0, 0, 3, 2))
        listtwo?.add(Data(0, 2, 1, 2))
        listtwo?.add(Data(1, 2, 2, 2))

        //获取手机屏幕高宽度
        val wm: WindowManager = this.windowManager
        height = wm.defaultDisplay.height
        width = wm.defaultDisplay.width

        grid_layout.columnCount = mainX //设置gridlayout 横向格子
        grid_layout.rowCount = mainY   //设置gridlayout 竖向格子

        str = intent.getStringExtra("action")

        if (str.equals("one")) {

            for (i in listone!!.indices) {
                val data: Data = listone!!.get(i)

                val fragmentlayout: FrameLayout = FrameLayout(this)
                fragmentLayouts?.add(fragmentlayout)
                fragmentlayout.id = View.generateViewId()
                setSpanRowCol(grid_layout, fragmentlayout, data.x, data.y, data.xn, data.yn)
                addFragment(EasyFragment.Single.getInstance(i.toString()), fragmentlayout.id)
            }
        } else {
            for (i in listtwo!!.indices) {
                val data: Data = listtwo!!.get(i)

                val fragmentlayout: FrameLayout = FrameLayout(this)
                fragmentLayouts?.add(fragmentlayout)
                fragmentlayout.id = View.generateViewId()
                setSpanRowCol(grid_layout, fragmentlayout, data.x, data.y, data.xn, data.yn)
                addFragment(EasyFragment.Single.getInstance(i.toString()), fragmentlayout.id)
            }
        }
        toast("显示布局:" + str)
    }

    /**
     * 设置Fragment组件 跨多少行 跨多少列
     * 这里不一样的要设置成 Fragment,其他各种组件都可以自己搭配
     *
     * @param grid grid控件
     * @param t    fragment布局
     * @param x    组件横向轴开始的索引
     * @param y    组件纵向轴开始的索引
     * @param xn   组件横向拉升位置 就是占几列
     * @param yn   组件列向拉升位置
     */
    fun setSpanRowCol(grid: GridLayout, t: FrameLayout, x: Int?, y: Int?, xn: Int?, yn: Int?) {

        val par = GridLayout.LayoutParams()   //每个子布局单独获取,并分配区域

        par.rowSpec = GridLayout.spec(y as Int, yn as Int)
        par.columnSpec = GridLayout.spec(x as Int, xn as Int)
        par.height = height / mainY * yn
        par.width = width / mainX * xn


        //判断子布局的上下左右是否为边界,是,就不留间隔.
        if (0 != y) {
            par.topMargin = 1
        }
        if (0 != x) {
            par.leftMargin = 1
        }
        if (mainX != (x + xn)) {
            par.rightMargin = 1
        }
        if (mainY != (y + yn)) {
            par.rightMargin = 1
        }

        t.layoutParams = par

        grid.addView(t, par)

    }

    /**
     * 数据Model
     */
    data class Data(val x: Int, val y: Int, val xn: Int, val yn: Int) {

    }

}

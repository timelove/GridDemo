package com.timelove.griddemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.GridLayout

class GridActivity : BaseActivity() {

    private var height = 0   //屏幕高度
    private var width = 0   //屏幕宽度
    private var mainX = 4        //x轴格子数
    private var mainY = 3        //Y轴格子数
    private var fragmentLayouts: ArrayList<FrameLayout>? = null
    private var fragmentList: ArrayList<Fragment>? = null


    var str:String ? =null
    var listone: ArrayList<IntArray>? = null
    var listtwo: ArrayList<IntArray>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_grid)


        listone?.add(intArrayOf(0, 0, 3, 2))
        listone?.add(intArrayOf(0, 2, 3, 2))


        listtwo?.add(intArrayOf(0, 0, 3, 2))
        listtwo?.add(intArrayOf(0, 2, 1, 2))
        listtwo?.add(intArrayOf(1, 2, 2, 2))

        //获取手机屏幕高宽度
        val wm: WindowManager = this.windowManager
        height = wm.defaultDisplay.height
        width = wm.defaultDisplay.width


        val fragmentlayout: FrameLayout = FrameLayout(this)
        fragmentLayouts?.add(fragmentlayout)

        fragmentList?.add(EasyFragment.Single.getInstance("1"))

        str = intent.getStringExtra("action")

        if(str.equals("one")){

            for(i in listone!!.indices){
               
            }

        }else{

        }
        toast("信息")
//        tab_layout.
    }


    /**
     * 设置Fragment组件 跨多少行 跨多少列
     *
     * @param grid grid控件
     * @param t    fragment布局
     * @param x    组件横向轴开始的索引
     * @param y    组件纵向轴开始的索引
     * @param xn   组件横向拉升位置 就是占几列
     * @param yn   组件列向拉升位置
     */
    fun setSpanRowCol(grid: GridLayout, t: FrameLayout, x: Int, y: Int, xn: Int, yn: Int) {

        val par = GridLayout.LayoutParams()   //每个子布局单独获取,并分配区域

        par.rowSpec = GridLayout.spec(y, yn)
        par.columnSpec = GridLayout.spec(Integer.valueOf(x)!!, Integer.valueOf(xn)!!)
        par.height = height / mainY * yn
        par.width = width / mainX * xn

        //判断子布局的上下左右是否为边界,是,就不控住间隔.
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
//        par.setMargins(1, 1, 1, 1);
        t.layoutParams = par

        grid.addView(t, par)

    }



}

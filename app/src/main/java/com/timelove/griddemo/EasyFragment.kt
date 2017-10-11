package com.timelove.griddemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author： bw
 * data：  2017.10.11 10:21
 * description: Fragment
 */
class EasyFragment : Fragment() {

    private var contentView: View = null!!//初始化,这里变量不再是空安全的
    private var mStr: String? = null

    object Single {
        fun getInstance(str: String): EasyFragment {
            val instance: EasyFragment = EasyFragment()
            instance.mStr = str
            return instance
        }
    }

//    class EasyFragment private constructor(Str :String) {
//
//        companion object{
//            var instance : EasyFragment?=null
//
//            fun getInstance(c:String) :EasyFragment{
//                if (instance == null) {
//                    synchronized(EasyFragment::class) {
//                        if (instance == null) {
//                            instance = EasyFragment(c)
//                        }
//                    }
//                }
//
//                return instance!!
//            }
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        if (null == contentView) {
            contentView = inflater!!.inflate(R.layout.fragment, container, false)
        } else {
            return contentView

        }
        return contentView
    }

    /**
     * 逻辑处理
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
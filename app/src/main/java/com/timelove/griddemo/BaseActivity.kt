package com.timelove.griddemo

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * author： bw
 * data：  2017.10.11 14:55
 * description: BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    /**
     * 跳转带参数
     * @param action id
     */
    inline fun <reified T : AppCompatActivity> AppCompatActivity.navigate(action: String, id: String) {
        val intent = Intent(this, T::class.java)
        intent.putExtra(action, id)
        startActivity(intent)
    }

    /**
     * 跳转带参数
     * @param action list
     */
    inline fun <reified T : AppCompatActivity> AppCompatActivity.navigate(action: String, list: IntArray) {
        val intent = Intent(this, T::class.java)
        intent.putExtra(action, list)
        startActivity(intent)
    }

    //Fragment 添加
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { add(frameId, fragment) }
    }


    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction { replace(frameId, fragment) }
    }

    fun AppCompatActivity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}
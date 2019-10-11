package com.example.admin.testdemo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Handler
import android.os.Message
import android.widget.TextView
import com.sitech.paas.common.model.BaseModel

/**
 * author  :mayong
 * function:
 * date    :2019-10-09
 **/
class Main2Model(name: String) : BaseModel() {
    private lateinit var tv: TextView
    var h = Handler()

    init {
        println("哈哈"+name)
    }
    fun get(tv: TextView) {
        this.tv = tv
        Thread(Runnable {
            Thread.sleep(5000)
            println("哈哈航aha")
            h.post(object : Runnable {
                override fun run() {
                    tv.text = "hahahhahahahahahha"
                }
            })
        }).start()
    }

    class SharedViewModelFactory(private val sharedName: String) :
            ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Main2Model(sharedName) as T
        }
    }

}
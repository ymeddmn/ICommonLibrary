package com.example.admin.testdemo

import android.hardware.display.DisplayManager
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.admin.testdemo.databinding.ActivityMain2Binding
import com.sitech.paas.common.activity.BaseActivity
import com.sitech.paas.common.utils.dp2px
import kotlinx.android.synthetic.main.activity_main2.*
import android.widget.ArrayAdapter
import android.widget.EditText




class Main2Activity : BaseActivity<ActivityMain2Binding, Main2Model>() {
    override fun getModel(): Main2Model {
        return Main2Model.SharedViewModelFactory("sdf").create(Main2Model::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel.get(btn)
//        val beginTransaction = supportFragmentManager.beginTransaction()
//        beginTransaction.add(Main2Fragment(), "sdf").commit()
        btn.setOnClickListener {
            showPopList(btn)
        }

    }


    fun showPop(view: View) {
        val window: PopupWindow
        window = PopupWindow(this)
        val b1 = Button(this)
        b1.setText("first")
        b1.setLayoutParams(LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

        val b2 = Button(this)
        b2.setText("Second")
        b2.setLayoutParams(LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

        val linearLayout = LinearLayout(this)
        linearLayout.addView(b1)
        linearLayout.addView(b2)
        linearLayout.orientation = LinearLayout.VERTICAL

        window.contentView = linearLayout
        window.setBackgroundDrawable(resources.getDrawable(android.R.drawable.alert_dark_frame))
        window.width = dp2px(this,150).toInt()
        window.height = dp2px(this,150).toInt()

        // 设置PopupWindow外部区域是否可触摸
        window.isFocusable = true //设置PopupWindow可获得焦点
        window.isTouchable = true //设置PopupWindow可触摸
        window.isOutsideTouchable = true //设置非PopupWindow区域可触摸
        window.showAsDropDown(view, 0, 0)
    }

    fun showPopList(view:View){
        var lists = ArrayList<String>()
        lists.add("one")
        lists.add("two")
        lists.add("three")
        var mListPop = ListPopupWindow(this)
        mListPop.setAdapter(ArrayAdapter<String>(this, R.layout.item_pop, lists))
        mListPop.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
        mListPop.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
        mListPop.setAnchorView(view)//设置ListPopupWindow的锚点，即关联PopupWindow的显示位置和这个锚点
        mListPop.setModal(true)//设置是否是模式
        mListPop.show()
    }

}

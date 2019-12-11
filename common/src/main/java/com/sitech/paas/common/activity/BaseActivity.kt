package com.sitech.paas.common.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sitech.paas.common.model.BaseModel

abstract class BaseActivity<B : ViewDataBinding, M : BaseModel> : AppCompatActivity() {

    lateinit var mBinding: B
    abstract fun getModel(): M
    lateinit var mModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateBefore()
        mBinding = DataBindingUtil.setContentView<B>(this, getLayoutId())
        mModel = getModel()
        getLifecycle().addObserver(mModel)
        initData()
        initView()
        initListener()
    }

    /**
     * setContentView之前调用
     */
    open fun onCreateBefore() {

    }

    open fun initListener() {


    }

    open fun initView() {


    }

    open fun initData() {


    }

    abstract fun getLayoutId(): Int
}

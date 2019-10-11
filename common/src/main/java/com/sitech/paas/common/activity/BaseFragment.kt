package com.sitech.paas.common.activity

import android.app.Activity
import android.database.DatabaseUtils
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sitech.paas.common.model.BaseModel


abstract class BaseFragment<B : ViewDataBinding, M : BaseModel> : Fragment() {
    private lateinit var mBinding: B
    abstract fun getModel(): M
    lateinit var mModel: M
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.setContentView<B>(activity as Activity, getLayoutId())
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mModel = getModel()
    }

    abstract fun getLayoutId(): Int
}

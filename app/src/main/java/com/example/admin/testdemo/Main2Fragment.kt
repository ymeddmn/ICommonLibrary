package com.example.admin.testdemo

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.admin.testdemo.databinding.FragmentMain2Binding
import com.sitech.paas.common.activity.BaseFragment
import com.sitech.paas.common.model.BaseModel


class Main2Fragment : BaseFragment<FragmentMain2Binding, Main2FragmentModel>() {
    override fun getModel(): Main2FragmentModel {
        return ViewModelProviders.of(this)[Main2FragmentModel::class.java]
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("航航行或")
    }

}

package com.ltn.exam.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import ltn.exam.R
import com.ltn.exam.base.BaseActivity
import ltn.exam.databinding.LayoutSplashBinding
import com.ltn.exam.ui.main.MainActivity
import com.ltn.exam.ui.main.MainViewModel
import com.ltn.exam.view_model.ViewModelFactory


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<MainViewModel, LayoutSplashBinding>() {

    override fun getContentLayout(): Int {
        return R.layout.layout_splash
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[MainViewModel::class.java]
    }

    override fun initView() {

    }

    override fun initListener() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun observerLiveData() {

    }
}

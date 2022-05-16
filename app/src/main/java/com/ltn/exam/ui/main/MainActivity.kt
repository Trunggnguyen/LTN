package com.ltn.exam.ui.main

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import ltn.exam.R
import com.ltn.exam.base.BaseActivity
import com.ltn.exam.base.PagerFragmentAdapter
import ltn.exam.databinding.LayoutMainBinding
import com.ltn.exam.ui.home.HomeFragment
import com.ltn.exam.ui.setting.SettingFragment
import com.ltn.exam.view_model.ViewModelFactory


class MainActivity : BaseActivity<MainViewModel, LayoutMainBinding>(){
    private lateinit var mPagerAdapter : PagerFragmentAdapter
    var isSetting = false

    companion object {
        fun getIntent(
            context: Context
        ): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }


    override fun getContentLayout(): Int {
        return R.layout.layout_main
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[MainViewModel::class.java]
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        paddingStatusBar(binding.root)
        initFragment()
        transparentStatusbar2()
    }

    override fun onBackPressed() {
        if (isSetting){
            binding.viewPager.currentItem = 0
            binding.settingw.visibility= View.VISIBLE
            binding.menuView.setImageResource(R.drawable.ic_menu)
        }else{
            super.onBackPressed()
        }

    }

    override fun initListener() {
        binding.settingw.setOnClickListener {
            isSetting = true
            binding.viewPager.currentItem = 1
            binding.settingw.visibility= View.GONE
            binding.menuView.setImageResource(R.drawable.ic_back)
        }
        binding.menuView.setOnClickListener {
            isSetting = false
            binding.viewPager.currentItem = 0
            binding.settingw.visibility= View.VISIBLE
            binding.menuView.setImageResource(R.drawable.ic_menu)
        }
    }

    override fun observerLiveData() {

    }

    private fun initFragment() {
        mPagerAdapter = PagerFragmentAdapter(supportFragmentManager)
        mPagerAdapter.addFragment(HomeFragment())
        mPagerAdapter.addFragment(SettingFragment())
        binding.viewPager.adapter = mPagerAdapter
        binding.viewPager.offscreenPageLimit = mPagerAdapter.count
        binding.viewPager.currentItem = 0
    }

}

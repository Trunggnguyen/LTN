//package com.ltn.exam.utils.custom_view
//
//import android.os.Bundle
//import android.view.View
//import com.ltn.exam.R
//import com.ltn.exam.base.BaseDialog
//import com.ltn.exam.databinding.LayoutDialogLogoutBinding
//
//class DialogLogout(logout: Logout) : BaseDialog<LayoutDialogLogoutBinding>() {
//    val logout = logout
//    override fun getLayoutResource(): Int {
//        return R.layout.layout_dialog_logout
//    }
//
//    override fun init(saveInstanceState: Bundle?, view: View?) {
//
//    }
//
//    override fun setUp(view: View?) {
//        binding.tvNo.setOnClickListener {
//            logout.onLogout(false)
//        }
//
//        binding.tvYes.setOnClickListener {
//            logout.onLogout(true)
//        }
//    }
//
//    interface Logout{
//        fun onLogout(logout: Boolean)
//    }
//}
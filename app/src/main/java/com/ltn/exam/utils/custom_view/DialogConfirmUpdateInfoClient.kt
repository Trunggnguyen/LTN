//package com.ltn.exam.utils.custom_view
//
//import android.os.Bundle
//import android.view.View
//import com.ltn.exam.R
//import com.ltn.exam.base.BaseDialog
//import com.ltn.exam.databinding.LayoutConfirmUpdateInforClientBinding
//
//class DialogConfirmUpdateInfoClient (cancleUpdate : CancleUpdate) : BaseDialog<LayoutConfirmUpdateInforClientBinding>() {
//    private val cancleRate = cancleUpdate
//    override fun getLayoutResource(): Int {
//        return R.layout.layout_confirm_update_infor_client
//    }
//
//    override fun init(saveInstanceState: Bundle?, view: View?) {
//
//    }
//
//    override fun setUp(view: View?) {
//        binding.tvNo.setOnClickListener {
//            cancleRate.onCancleUpdate(false)
//            dismiss()
//        }
//        binding.tvYes.setOnClickListener {
//            cancleRate.onCancleUpdate(true)
//            dismiss()
//        }
//    }
//
//    interface CancleUpdate{
//        fun onCancleUpdate(cancle: Boolean)
//    }
//}
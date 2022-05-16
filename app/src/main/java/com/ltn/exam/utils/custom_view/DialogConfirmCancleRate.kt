//package com.ltn.exam.utils.custom_view
//
//import android.os.Bundle
//import android.view.View
//import com.ltn.exam.R
//import com.ltn.exam.base.BaseDialog
//import com.ltn.exam.databinding.LayoutConfirmCancleRateBinding
//
//class DialogConfirmCancleRate(cancleRate : CancleRate) : BaseDialog<LayoutConfirmCancleRateBinding>() {
//    val cancleRate = cancleRate
//    override fun getLayoutResource(): Int {
//        return R.layout.layout_confirm_cancle_rate
//    }
//
//    override fun init(saveInstanceState: Bundle?, view: View?) {
//
//    }
//
//    override fun setUp(view: View?) {
//        binding.tvNo.setOnClickListener {
//            cancleRate.onCancleRate(false)
//            dismiss()
//        }
//        binding.tvYes.setOnClickListener {
//            cancleRate.onCancleRate(true)
//            dismiss()
//        }
//    }
//
//    interface CancleRate{
//        fun onCancleRate(cancle: Boolean)
//    }
//}
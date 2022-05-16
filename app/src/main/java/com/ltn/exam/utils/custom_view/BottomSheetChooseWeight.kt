//package com.ltn.exam.utils.custom_view
//
//import android.os.Bundle
//import android.view.View
//import com.ltn.exam.R
//import com.ltn.exam.base.BaseBottomSheetDialog
//import com.ltn.exam.databinding.LayoutChooseWeightBinding
//
//class BottomSheetChooseWeight(getWeight : GetWeight) : BaseBottomSheetDialog<LayoutChooseWeightBinding>() {
//    val getWeight = getWeight
//    override fun getLayoutResource(): Int {
//        return R.layout.layout_choose_weight
//    }
//
//    override fun initView(saveInstanceState: Bundle?, view: View?) {
//        binding.numberPicker.minValue = 3
//        binding.numberPicker.maxValue = 635
//        binding.numberPicker.wrapSelectorWheel = true
//        binding.numberPicker.value = 60
//    }
//
//    override fun initListener(view: View?) {
//        binding.numberPicker.setOnValueChangedListener { picker, oldVal, newVal -> getWeight.onGetWeight(newVal) }
//    }
//
//    interface GetWeight{
//        fun onGetWeight(weight : Int)
//    }
//}
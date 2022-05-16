package com.ltn.exam.utils.custom_view

import android.os.Bundle
import android.view.View

import com.ltn.exam.base.BaseBottomSheetDialog
import ltn.exam.R
import ltn.exam.databinding.LayoutDialogSelcetBinding


class BottomSheetChooseHeight(getHeight : GetHeight, numberPick: Int, type: Int) : BaseBottomSheetDialog<LayoutDialogSelcetBinding>() {
    val type = type
    val munberPick = numberPick
    val getHeight = getHeight
    override fun getLayoutResource(): Int {
        return R.layout.layout_dialog_selcet
    }

    override fun initView(saveInstanceState: Bundle?, view: View?) {
        binding.numberPicker.minValue = 0
        binding.numberPicker.maxValue = 100
        binding.numberPicker.wrapSelectorWheel = true
        binding.numberPicker.value = munberPick
    }

    override fun initListener(view: View?) {
        binding.numberPicker.setOnValueChangedListener { picker, oldVal, newVal -> getHeight.onGetHeight(newVal, type) }
    }

    interface GetHeight{
        fun onGetHeight(height : Int, type: Int)
    }
}
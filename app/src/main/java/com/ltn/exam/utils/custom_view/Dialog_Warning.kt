package com.ltn.exam.utils.custom_view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ltn.exam.base.BaseDialog
import ltn.exam.R
import ltn.exam.databinding.LayoutDialogDasBinding
import ltn.exam.databinding.LayoutDialogInputBinding

class Dialog_Warning(getClickInput: GetClicknput, type: String) : BaseDialog<LayoutDialogDasBinding>() {
    val getClickinput = getClickInput
    val type = type

    override fun getLayoutResource(): Int {
        return R.layout.layout_dialog_das
    }

    override fun init(saveInstanceState: Bundle?, view: View?) {
    }

    override fun setUp(view: View?) {
        binding.tvInput.text = type
        binding.tvClose.setOnClickListener {
            dialog?.dismiss()
        }
    }

    interface GetClicknput {
        fun onGetClickInput(click: String, type : Int)
    }
}
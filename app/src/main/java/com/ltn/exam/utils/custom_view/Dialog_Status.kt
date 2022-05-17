package com.ltn.exam.utils.custom_view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ltn.exam.base.BaseDialog
import ltn.exam.R
import ltn.exam.databinding.LayoutDialogInputBinding

class Dialog_Status(getClickInput: GetClicknput, type: Int, text: String) : BaseDialog<LayoutDialogInputBinding>() {
    val getClickinput = getClickInput
    val type = type
    val text = text

    override fun getLayoutResource(): Int {
        return R.layout.layout_dialog_input
    }

    override fun init(saveInstanceState: Bundle?, view: View?) {
    }

    override fun setUp(view: View?) {
        binding.tvInput.setText(text)
        when (type) {
            1 -> {
                binding.tvTitle.text = binding.root.context.getString(R.string.str_temp)
            }
            2 -> {
                binding.tvTitle.text = binding.root.context.getString(R.string.str_temp)
            }
            3 -> {
                binding.tvTitle.text = binding.root.context.getString(R.string.str_humi)
            }
            else -> {
                binding.tvTitle.text = binding.root.context.getString(R.string.str_humi)
            }
        }
        binding.tvComf.setOnClickListener {
            if (binding.tvInput.text.toString()!=""){
                getClickinput.onGetClickInput(binding.tvInput.text.toString(), type)
            }else{
                Toast.makeText(binding.root.context, "Input null !!!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.tv.setOnClickListener {
            dialog?.dismiss()
        }
    }

    interface GetClicknput {
        fun onGetClickInput(click: String, type : Int)
    }
}
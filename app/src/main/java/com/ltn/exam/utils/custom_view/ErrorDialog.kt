package com.ltn.exam.utils.custom_view

import android.os.Bundle
import android.view.View
import ltn.exam.R
import com.ltn.exam.base.BaseDialog
import ltn.exam.databinding.LayoutErrorDialogBinding

class ErrorDialog (errorString : String) : BaseDialog<LayoutErrorDialogBinding>() {
    val errorShow = errorString

    override fun getLayoutResource(): Int {
        return R.layout.layout_error_dialog
    }

    override fun init(saveInstanceState: Bundle?, view: View?) {
    }

    override fun setUp(view: View?) {
        binding.tvError.text = errorShow
    }
}
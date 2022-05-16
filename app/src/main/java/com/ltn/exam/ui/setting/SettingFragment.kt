package com.ltn.exam.ui.setting

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import ltn.exam.R
import com.ltn.exam.base.BaseFragment
import com.ltn.exam.data.DataRequest
import ltn.exam.databinding.FragmentSettingBinding
import com.ltn.exam.ui.main.MainViewModel
import com.ltn.exam.utils.custom_view.BottomSheetChooseHeight
import com.ltn.exam.utils.custom_view.Dialog_Status
import com.ltn.exam.view_model.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : BaseFragment<MainViewModel, FragmentSettingBinding>() ,Dialog_Status.GetClicknput, BottomSheetChooseHeight.GetHeight{
    private var dislodging: Dialog_Status? = null
    private var dislodgingSelect: BottomSheetChooseHeight? = null
    override fun getContentLayout(): Int {
        return R.layout.fragment_setting
    }
    var temp = 0
    var tempth = 0
    var tempmax = 0
    var tempMin = 0
    var humi = 0
    var humiM = 0



    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext()))[MainViewModel::class.java]
    }

    override fun initView() {

        binding.tv1.setOnClickListener {
            dislodging = Dialog_Status(this,1)
            dislodging?.show(activity!!.supportFragmentManager, null)
        }
        binding.tv2.setOnClickListener {
            dislodging = Dialog_Status(this,2)
            dislodging?.show(activity!!.supportFragmentManager, null)
        }
        binding.tv3.setOnClickListener {
            dislodgingSelect = BottomSheetChooseHeight(this,tempth, 3)
            dislodgingSelect?.show(activity!!.supportFragmentManager, null)
        }
        binding.tv4.setOnClickListener {
            dislodging = Dialog_Status(this,4)
            dislodging?.show(activity!!.supportFragmentManager, null)
        }
        binding.tv5.setOnClickListener {
            dislodging = Dialog_Status(this,5)
            dislodging?.show(activity!!.supportFragmentManager, null)
        }
        binding.tv6.setOnClickListener {
            dislodgingSelect = BottomSheetChooseHeight(this,humiM, 6)
            dislodgingSelect?.show(activity!!.supportFragmentManager, null)
        }
    }

    override fun initListener() {

    }

    @SuppressLint("SetTextI18n")
    override fun observerLiveData() {
        viewModel.getData {
            binding.tv1.text = it.tempStr1
            binding.tv2.text = it.tempStr2
            binding.tv3.text = "TempTheshold: "+ it.tempTheshold
            binding.tv4.text = it.humiStr1
            binding.tv5.text = it.humiStr2
            binding.tv6.text = "HumiTheshold: "+ it.humiTheshold
            temp = it.temp!!
            humi = it.humi!!
            tempmax = it.tempMax!!
            tempMin = it.tempMin!!
            tempth = it.tempTheshold!!
            humiM = it.humiTheshold!!
        }
    }

    override fun onGetClickInput(click: String, type: Int) {
        when (type) {
            1 -> {
                binding.tv1.text = click
            }
            2 -> {
                binding.tv2.text = click
            }
            4 -> {
                binding.tv4.text = click
            }
            5 -> {
                binding.tv5.text = click
            }
        }
        saveData()
        dislodging?.dismiss()
    }
    override fun onGetHeight(height: Int, type: Int) {
        when (type) {
            3 -> {
                binding.tv3.text = "HumiTheshold: "+ height
                tempth = height
            }
            6 -> {
                binding.tv6.text = "HumiTheshold: "+ height
                humiM = height
            }

        }
        saveData()
    }
    fun saveData(){
        viewModel.saveToFirebase(DataRequest(humi,tv4.text.toString(),tv5.text.toString(),humiM,temp,tempmax,tempMin, tv1.text.toString(),tv2.text.toString(),tempth))
    }


}
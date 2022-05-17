package com.ltn.exam.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ltn.exam.R
import com.ltn.exam.base.BaseFragment
import com.ltn.exam.data.DataRequest
import com.ltn.exam.data.DataResponse
import ltn.exam.databinding.FragmentHomeBinding
import com.ltn.exam.ui.main.MainViewModel
import com.ltn.exam.utils.custom_view.Dialog_Status
import com.ltn.exam.utils.custom_view.Dialog_Warning
import com.ltn.exam.view_model.ViewModelFactory

class HomeFragment : BaseFragment<MainViewModel, FragmentHomeBinding>(), Dialog_Warning.GetClicknput {
    var isOn = false
    var dislodging : Dialog_Warning ? = null
    override fun getContentLayout(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(requireContext()))[MainViewModel::class.java]

    }

    override fun initView() {
        isOn = viewModel.getOn()
        if (isOn){
            binding.btOn.setImageResource(R.drawable.ic_on)

        }else{
            binding.btOn.setImageResource(R.drawable.ic_off)
        }
        //viewModel.saveToFirebase(DataRequest(10,"aaa","aaa", 10,100,1,1,"1","1",10))
    }

    override fun initListener() {
        binding.btOn.setOnClickListener {
            if (isOn){
                binding.btOn.setImageResource(R.drawable.ic_off)
                isOn = false
                viewModel.setOn(false)
                observerLiveData()

            }else{
                isOn = true
                binding.btOn.setImageResource(R.drawable.ic_on)
                viewModel.setOn(true)
                observerLiveData()
            }
        }

    }

    @SuppressLint("SetTextI18n")
    override fun observerLiveData() {
        viewModel.getData {
            if (isOn){
                val hasWindowFocus = activity?.supportFragmentManager!!.fragments.any { it is DialogFragment }
                if (!hasWindowFocus){
                    if(it.temp!!>= it.tempTheshold!!){
                        vibratePhone()
                        dislodging = Dialog_Warning(this,it.tempStr2!!)
                        dislodging?.show(activity!!.supportFragmentManager, null)
                    }
                    if(it.humi!!>= it.humiTheshold!!){
                        dislodging = Dialog_Warning(this,it.humiStr2!!)
                        dislodging?.show(activity!!.supportFragmentManager, null)
                        vibratePhone()
                    }
                }
                binding.min.text = "Min: "+ it.tempMin
                binding.max.text = "Max: "+ it.tempMax

                binding.nhietdo.text = it.temp.toString()
                binding.doam.text =  "Humidity: "+ it.humi+ "%"
                if (it.temp!! > it.tempTheshold!!){
                    binding.text1.text =  it.tempStr2
                }else{
                    binding.text1.text =  it.tempStr1
                }
                if (it.humi!! > it.humiTheshold!!){
                    binding.text2.text =  it.humiStr2
                }else{
                    binding.text2.text =  it.humiStr1
                }
                if (it.temp!!> it.tempMax!!){
                    viewModel.saveToFirebaseMax(it.temp!!)
                }
                if (it.temp!!< it.tempMin!!){
                    viewModel.saveToFirebaseMin(it.temp!!)
                }
                if (it.tempMin!! == 0 ){
                    viewModel.saveToFirebaseMin(it.temp!!)
                }
            }else{
                binding.min.text = "Min: --"
                binding.max.text = "Max: --"
                viewModel.saveToFirebaseMax(0)
                viewModel.saveToFirebaseMin(0)
                binding.nhietdo.text = "--"
                binding.doam.text =  "Humidity: "+ "--%"
                binding.text1.text =  "--"
                binding.text2.text =  "--"
            }
        }

    }
    fun Fragment.vibratePhone() {
        val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200)
        }
    }

    override fun onGetClickInput(click: String, type: Int) {

    }


}
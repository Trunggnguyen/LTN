package com.ltn.exam.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ltn.exam.data.DataManager
import com.ltn.exam.data.DataRequest
import com.ltn.exam.data.DataResponse
import com.ltn.exam.data.START
import com.ltn.exam.network.Api
import com.ltn.exam.view_model.BaseViewModel
import javax.inject.Inject


@SuppressLint("CheckResult")
class MainViewModel(val context: Context) : BaseViewModel() {
    @Inject
    lateinit var dataManager: DataManager

    @Inject
    lateinit var api: Api
    val database = Firebase.database("https://demonhung-ff21f-default-rtdb.firebaseio.com").reference
    fun saveToFirebase(dataRequest: DataRequest) {
            database.child("dht11").setValue(dataRequest)
            .addOnSuccessListener {
                Log.d("TAG", "saveToFirebase: ok")
            }
             .addOnFailureListener {
                 Log.d("TAG", "saveToFirebase: no ok")
            }
    }
    fun saveToFirebaseMin(dataRequest: Int) {
        database.child("dht11").child("tempMin").setValue(dataRequest)
            .addOnSuccessListener {
                Log.d("TAG", "saveToFirebase: ok")
            }
            .addOnFailureListener {
                Log.d("TAG", "saveToFirebase: no ok")
            }
    }

    fun getOn(): Boolean {
        return if (dataManager.getBoolean(START) != null)
            dataManager.getBoolean(START)
        else {
          false
        }
    }
    fun setOn(isOn: Boolean) {
        dataManager.save(START, isOn)
    }

    fun saveToFirebaseMax(dataRequest: Int) {
        database.child("dht11").child("tempMax").setValue(dataRequest)
            .addOnSuccessListener {
                Log.d("TAG", "saveToFirebase: ok")
            }
            .addOnFailureListener {
                Log.d("TAG", "saveToFirebase: no ok")
            }
    }

    fun getData(callbackSuccess: (list: DataResponse) -> Unit){
        val dataAddnode = database.child("dht11")
        dataAddnode.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                    val wishlistAdd = snapshot.getValue(DataResponse::class.java)
                    wishlistAdd?.let { it}
                    Log.d("DATA", snapshot.toString())
                callbackSuccess.invoke(wishlistAdd!!)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("DATA", error.toString())
            }
        })
    }



}
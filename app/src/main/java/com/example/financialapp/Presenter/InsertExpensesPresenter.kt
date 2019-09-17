package com.example.financialapp.Presenter

import android.util.Log
import com.example.financialapp.Model.Payment
import com.example.financialapp.Model.User
import com.example.financialapp.View.ILoginView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class InsertExpensesPresenter(): InterfacePaymentPresenter {

    override fun createBill() {

    }

    override fun savePaymentInFirebase(price: String, description: String, date: String) {
        val uid = FirebaseAuth.getInstance().uid.toString()
        val payment = Payment(uid, price, description, date, organization = null)
        FirebaseFirestore.getInstance().collection("payments")
                .document(uid)
                .collection("payments_user")
                .document()
                .set(payment)
                .addOnCompleteListener{
                    if(it.isSuccessful) {
                        Log.d("teste", "salvo no firebase")
                    }
                }.addOnFailureListener{
                    Log.e("teste", it.message, it)
                }

    }
}
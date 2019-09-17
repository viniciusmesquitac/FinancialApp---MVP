package com.example.financialapp.Presenter

import android.util.Log
import com.example.financialapp.Model.Payment
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*

class FirebaseRequest: InterfaceFirestoreRequest {

    override fun fetchFirebasePayments(): Task<QuerySnapshot> {
        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        var paymentsList: MutableList<Payment> = mutableListOf<Payment>()

        return FirebaseFirestore.getInstance().collection("payments")
                .document(uid)
                .collection("payments_user")
                .get()
    }

}
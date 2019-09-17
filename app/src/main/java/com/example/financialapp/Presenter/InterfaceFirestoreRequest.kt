package com.example.financialapp.Presenter

import com.example.financialapp.Model.Payment
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface InterfaceFirestoreRequest {
    fun fetchFirebasePayments(): Task<QuerySnapshot>
}
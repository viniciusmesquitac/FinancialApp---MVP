package com.example.financialapp.Presenter

interface InterfacePaymentPresenter {
    fun createBill()
    fun savePaymentInFirebase(price: String, description: String,date: String)
}
package com.example.financialapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.financialapp.Model.Payment
import com.example.financialapp.R
import kotlinx.android.synthetic.main.payment_item.view.*

class PaymentAdapter(val payments: MutableList<Payment>): RecyclerView.Adapter<PaymentAdapter.ContactViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.payment_item, parent, false)
        return ContactViewHolder(inflate)
    }

    override fun getItemCount(): Int = payments.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(payments[position])
    }

    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(payment: Payment) {
            with(payment){
                itemView.txt_name_contact.text = description
            }
        }
    }


}
package com.example.financialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financialapp.Presenter.InsertExpensesPresenter
import com.example.financialapp.Presenter.InterfacePaymentPresenter
import kotlinx.android.synthetic.main.activity_insert_expenses.*

class InsertExpensesActivity : AppCompatActivity() {

    internal lateinit var insertExpensesPresenter: InsertExpensesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_expenses)
        setSupportActionBar(toolbar_expenses)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // MARK: INITIALIZE PRESENTER

        insertExpensesPresenter = InsertExpensesPresenter()

        btnCreatePayment.setOnClickListener {
            insertExpensesPresenter.savePaymentInFirebase(editPrice.text.toString(),
                    editDescription.text.toString(),
                    editDate.text.toString())
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}

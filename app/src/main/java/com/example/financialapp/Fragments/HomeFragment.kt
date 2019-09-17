package com.example.financialapp.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financialapp.Adapter.PaymentAdapter
import com.example.financialapp.Model.Payment
import com.example.financialapp.Presenter.FirebaseRequest

import com.example.financialapp.R
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {


    private lateinit var adapter: PaymentAdapter
    private lateinit var myPayments : MutableList<Payment>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val firebaseRequest = FirebaseRequest()
        myPayments = mutableListOf<Payment>()

        firebaseRequest.fetchFirebasePayments().addOnSuccessListener {documents ->
            for (document in documents) {
                if(document.exists()) {
                    val payment = document.toObject(Payment::class.java)
                    myPayments.add(0,payment)
                }

            }
            adapter = PaymentAdapter(myPayments)
            recycler_view?.adapter = adapter
            recycler_view?.layoutManager = activity?.let { LinearLayoutManager(it) }
        }



    }


}

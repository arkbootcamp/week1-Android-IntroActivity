package com.erdin.latihanandroidweek1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.erdin.latihanandroidweek1.R

class FragmentA(private val listener: AListener?) : Fragment() {

    private lateinit var rootView: View

    companion object {
        const val EXTRA_INFO = "EXTRA_INFO"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_a, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoA = arguments?.getString(EXTRA_INFO, "FRAGMENT A")
        rootView.findViewById<TextView>(R.id.tv_title_a).text = infoA
        val btnChangeA = rootView.findViewById<Button>(R.id.btn_info_a)
        btnChangeA.setOnClickListener {
            listener?.onChangeAClicked()
        }
    }

    interface AListener {
       fun onChangeAClicked()
    }

}
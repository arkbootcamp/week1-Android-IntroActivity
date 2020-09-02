package com.erdin.latihanandroidweek1.dialog

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ActivitySimpleDialogBinding
import com.erdin.latihanandroidweek1.databinding.DialogAlertTestBinding

class SimpleDialogActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivitySimpleDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_dialog)

        binding.btnShowDialogOne.setOnClickListener(this)
        binding.btnShowDialogTwo.setOnClickListener(this)
        binding.btnShowDialogThree.setOnClickListener(this)
        binding.btnShowDialogFour.setOnClickListener(this)
        binding.btnShowDialogFive.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_show_dialog_one -> {
                showDialogOne()
            }
            R.id.btn_show_dialog_two -> {
                showDialogTwo()
            }
            R.id.btn_show_dialog_three -> {
                showDialogThree()
            }
            R.id.btn_show_dialog_four -> {
                showDialogFour()
            }
            R.id.btn_show_dialog_five -> {
                showDialogFive()
            }

        }
    }

    private fun showDialogOne() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Test Dialog One")
            .setMessage("Ini dialog satu")
            .create()
        dialog.show()
    }

    private fun showDialogTwo() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Konfirmasi User")
            .setPositiveButton("Show Toast") { dialog: DialogInterface?, which: Int ->
                Toast.makeText(this,"Show Dialog", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Dismiss") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
        dialog.show()
    }

    private fun showDialogThree() {
        val rootView = DataBindingUtil.inflate<DialogAlertTestBinding>(layoutInflater, R.layout.dialog_alert_test, null, false)

        val dialog = AlertDialog.Builder(this)
            .setView(rootView.root)
            .setCancelable(false)
            .create()
        dialog.show()
        rootView.btnOk.setOnClickListener { dialog.dismiss() }

    }

    private fun showDialogFour() {
        // Dialog Fragment
        try {
            val dialogFragment = supportFragmentManager.findFragmentByTag(TestDialogFragment.TAG)
            if (dialogFragment != null) {
                supportFragmentManager.beginTransaction().remove(dialogFragment).commit()
            }

            TestDialogFragment().show(supportFragmentManager, TestDialogFragment.TAG)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun showDialogFive() {
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                // Action saat memilih tanggal

            }, 2020, 8, 2
        ).show()
    }

}
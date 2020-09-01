package com.erdin.latihanandroidweek1.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.erdin.latihanandroidweek1.ConstraintLayoutActivity
import com.erdin.latihanandroidweek1.OneActivity
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.fragment.SimpleFragmentActivity

class SimpleToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_toolbar)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_show_toast -> {
                Toast.makeText(this, "Menu Toast", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_to_second_activity -> {
                val intent = Intent(this, SimpleFragmentActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.setting -> {
                // Actionnya mau apa
                return true
            }
            R.id.setting2 -> {
                // Actionnya mau apa
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
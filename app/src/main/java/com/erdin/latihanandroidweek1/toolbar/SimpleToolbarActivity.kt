package com.erdin.latihanandroidweek1.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.erdin.latihanandroidweek1.ConstraintLayoutActivity
import com.erdin.latihanandroidweek1.OneActivity
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.SimpleDataBindingActivity
import com.erdin.latihanandroidweek1.dialog.SimpleDialogActivity
import com.erdin.latihanandroidweek1.fragment.SimpleFragmentActivity
import com.erdin.latihanandroidweek1.recyclerview.SimpleRecyclerViewActivity
import com.erdin.latihanandroidweek1.sharedpref.LearnSharedPrefActivity
import com.erdin.latihanandroidweek1.tabpager.SimpleTabPagerActivity
import com.erdin.latihanandroidweek1.webview.SimpleWebViewActivity

class SimpleToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_toolbar)

        val defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val txtContentToolbar = findViewById<TextView>(R.id.tv_content_toolbar)

        txtContentToolbar.text = defaultSharedPref.getString(LearnSharedPrefActivity.KEY_EMAIL, "Content Toolbar")

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
            R.id.action_to_data_binding_activity -> {
                val intent = Intent(this, SimpleDataBindingActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_to_dialog_activity -> {
                val intent = Intent(this, SimpleDialogActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_to_tab_view_pager -> {
                val intent = Intent(this, SimpleTabPagerActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_to_web_view -> {
                val intent = Intent(this, SimpleWebViewActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_to_recycler_view -> {
                val intent = Intent(this, SimpleRecyclerViewActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_to_shared_pref_screen -> {
                val intent = Intent(this, LearnSharedPrefActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
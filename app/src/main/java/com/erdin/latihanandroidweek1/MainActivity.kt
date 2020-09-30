package com.erdin.latihanandroidweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.erdin.latihanandroidweek1.drawer.SimpleDrawerActivity
import com.erdin.latihanandroidweek1.room.WordListActivity
import com.erdin.latihanandroidweek1.toolbar.SimpleToolbarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnActivityA = findViewById<Button>(R.id.btn_to_activity_a)
        val btnActivityB = findViewById<Button>(R.id.btn_to_activity_b)
        val btnActivityLL = findViewById<Button>(R.id.btn_to_linear_layout)
        val btnActivityFL = findViewById<Button>(R.id.btn_to_frame_layout)
        val btnActivityRL = findViewById<Button>(R.id.btn_to_relative_layout)
        val btnActivityCL = findViewById<Button>(R.id.btn_to_constraint_layout)
        val btnToolbar = findViewById<Button>(R.id.btn_to_toolbar)

        btnActivityB.text = "To Room Activity"

        btnActivityA.setOnClickListener {
            val intentA = Intent(this, OneActivity::class.java)
            intentA.putExtra("domainName", "arkademy.com")
            startActivity(intentA)
        }

        btnActivityB.setOnClickListener {
            val intentB = Intent(this, WordListActivity::class.java)
            startActivity(intentB)
        }

        btnActivityLL.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnActivityFL.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        btnActivityRL.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        btnActivityCL.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        btnToolbar.setOnClickListener {
            val intent = Intent(this, SimpleToolbarActivity::class.java)
            startActivity(intent)
        }

        Toast.makeText(this, "Activity: OnCreate()", Toast.LENGTH_LONG).show()
        Log.d("lifecycle", "OnCreate()")
    }

    override fun onStart() {
        super.onStart()

        Log.d("lifecycle", "OnStart()")
        Toast.makeText(this, "Activity: OnStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        Log.d("lifecycle", "OnResume()")
        Toast.makeText(this, "Activity: OnResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        Log.d("lifecycle", "OnPause()")
        Toast.makeText(this, "Activity: OnPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        Log.d("lifecycle", "OnStop()")
        Toast.makeText(this, "Activity: OnStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("lifecycle", "OnRestart()")
        Toast.makeText(this, "Activity: OnRestart()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("lifecycle", "onDestroy()")
        Toast.makeText(this, "Activity: OnDestroy()", Toast.LENGTH_LONG).show()
    }
}
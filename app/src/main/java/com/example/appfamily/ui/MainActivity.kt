package com.example.appfamily.ui

import android.content.Intent
import android.location.SettingInjectorService
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.appfamily.ContactFragment
import com.example.appfamily.R
import com.example.appfamily.databinding.ContactBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.finish -> {
                finish()
                true
            }
            R.id.action_settings -> {
                startActivity(Intent(this, ContactFragment::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
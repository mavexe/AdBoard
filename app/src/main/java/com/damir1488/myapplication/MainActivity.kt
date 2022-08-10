package com.damir1488.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.damir1488.myapplication.DialogHelper.DialogHelper
import com.damir1488.myapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init() {
        val toggle = ActionBarDrawerToggle(this,binding.draweLayout,toolbar,R.string.vxod,R.string.vixod)
        binding.draweLayout.addDrawerListener(toggle)
        toggle.syncState()
       binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.myads ->{Toast.makeText(this,"Pressed my ads",Toast.LENGTH_LONG).show()}
            R.id.cars ->{Toast.makeText(this,"Pressed my cars",Toast.LENGTH_LONG).show()}
            R.id.phones->{}
            R.id.computers->{}
            R.id.domestic->{}
            R.id.signup->{dialogHelper.createSignDialog(DialogHelper.SIGN_UP_STATE)}
            R.id.signin->{dialogHelper.createSignDialog(DialogHelper.SIGN_IN_STATE)}
            R.id.signout->{}
        }
        draweLayout.closeDrawer(GravityCompat.START)
        return true
    }


}
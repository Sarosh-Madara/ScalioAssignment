package com.scalioassignment.app.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.scalioassignment.app.R
import com.scalioassignment.app.base.BaseActivity
import com.scalioassignment.app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import android.content.res.Configuration
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.ui.setupActionBarWithNavController


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var bi: ActivityMainBinding
    lateinit var navController: NavController

    fun setupViews() {
        // Navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
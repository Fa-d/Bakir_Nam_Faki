package com.kolpolok.nord.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.kolpolok.nord.R
import com.kolpolok.nord.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        supportActionBar?.hide()
    }

    private fun initView() {
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_profile,
            R.id.navigation_home,
            R.id.navigation_servers,
            R.id.navigation_settings,

            ).build()
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment).navController
        setupActionBarWithNavController(this, navController, appBarConfiguration)
        setupWithNavController(binding.navView, navController)
    }
}
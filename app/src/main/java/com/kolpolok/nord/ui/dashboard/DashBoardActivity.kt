package com.kolpolok.nord.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.kolpolok.nord.R
import com.kolpolok.nord.databinding.ActivityDashBoardBinding
import com.kolpolok.nord.ui.dashboard.bottomsheet.ServerMainAdapter
import com.mapbox.mapboxsdk.Mapbox

class DashBoardActivity : AppCompatActivity(), NavChangeListener {
    private lateinit var binding: ActivityDashBoardBinding
    var isPauseSelected = false
    var isDisconnectSelected = false
    var isFavServerSelected = false
    var isSpecificServerSelected = false
    val adapterte = ServerMainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        Mapbox.getInstance(this, "CJohxxcGpBibDmzgcIFH")
        setContentView(binding.root)
        initView()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        supportActionBar?.hide()
        initClickListener()
        initViewBottomSheet()
    }

    private fun initViewBottomSheet() {
        binding.bottomSheetParent.imageSpecser.setColorFilter(
            ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
        )
        binding.bottomSheetParent.favServerText.setTextColor(
            ContextCompat.getColor(this, R.color.textColor)
        )
        binding.bottomSheetParent.specificServerText.setTextColor(
            ContextCompat.getColor(this, R.color.textColor)
        )
        binding.bottomSheetParent.imagefavser.setColorFilter(
            ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
        )

        binding.bottomSheetParent.layoutFavServer.setCardBackgroundColor(
            ContextCompat.getColor(this, R.color.cardViewUnSelectedColor)
        )
        binding.bottomSheetParent.layoutSpecificServer.setCardBackgroundColor(
            ContextCompat.getColor(this, R.color.cardViewUnSelectedColor)
        )
    }

    private fun initClickListener() {
        val tempData = listOf(
            listOf(
                "asdasdasdasdasdasdasd", "asdasdasdasdasdasdasd", "asdasdasdasdasdasdasd"
            ),
            listOf(
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
            ),
            listOf("asdasdasdasdasdasdasd"),
            listOf("asdasdasdasdasdasdasd", "asdasdasdasdasdasdasd"),
            listOf(
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
                "asdasdasdasdasdasdasd",
            )
        )
        adapterte.initLoad(tempData)

        binding.bottomSheetParent.connectReallyButton.setOnClickListener {
            binding.bottomSheetParent.titleTexxt.setTextColor(
                ContextCompat.getColor(this, R.color.internetConnectedTextColor)
            )
            binding.bottomSheetParent.titleTexxt.text = "You Internet secure now"
            binding.bottomSheetParent.sheildIcon.setBackgroundResource(R.drawable.connected_shield)
            binding.bottomSheetParent.connectReallyButton.visibility = View.GONE
            binding.bottomSheetParent.selectServerslayout.visibility = View.GONE
            binding.bottomSheetParent.pauseDisButton.visibility = View.VISIBLE
        }
        bottomNavigationClickListener()
        binding.bottomSheetParent.pauseButton.setOnClickListener {
            binding.bottomSheetParent.pauseButton.setBackgroundColor(
                ContextCompat.getColor(this, R.color.buttonSelectedColor)
            )
            binding.bottomSheetParent.disconnectButton.setBackgroundColor(
                ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
            )
            /*binding.bottomSheetParent.connectReallyButton.visibility = View.VISIBLE
              binding.bottomSheetParent.selectServerslayout.visibility = View.VISIBLE
              binding.bottomSheetParent.pauseDisButton.visibility = View.GONE*/
            isPauseSelected = true
            isDisconnectSelected = false
        }
        binding.bottomSheetParent.disconnectButton.setOnClickListener {
            binding.bottomSheetParent.titleTexxt.setTextColor(
                ContextCompat.getColor(this, R.color.internetDisConnectedTextColor)
            )
            binding.bottomSheetParent.titleTexxt.text = "You Internet isn't secure"
            binding.bottomSheetParent.sheildIcon.setBackgroundResource(R.drawable.not_connected_shield)
            binding.bottomSheetParent.pauseButton.setBackgroundColor(
                ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
            )

            binding.bottomSheetParent.connectReallyButton.visibility = View.VISIBLE
            binding.bottomSheetParent.selectServerslayout.visibility = View.VISIBLE
            binding.bottomSheetParent.pauseDisButton.visibility = View.GONE
            isPauseSelected = false
            isDisconnectSelected = true
        }
        binding.bottomSheetParent.layoutFavServer.setOnClickListener {
            isFavServerSelected = true
            isSpecificServerSelected = false
            binding.bottomSheetParent.imagefavser.setColorFilter(
                ContextCompat.getColor(this, R.color.buttonSelectedColor)
            )
            binding.bottomSheetParent.favServerText.setTextColor(
                ContextCompat.getColor(this, R.color.buttonSelectedColor)
            )
            binding.bottomSheetParent.specificServerText.setTextColor(
                ContextCompat.getColor(this, R.color.textColor)
            )
            binding.bottomSheetParent.imageSpecser.setColorFilter(
                ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
            )
            binding.bottomSheetParent.layoutFavServer.setCardBackgroundColor(
                ContextCompat.getColor(this, R.color.cardViewSelectedColor)
            )
            binding.bottomSheetParent.layoutSpecificServer.setCardBackgroundColor(
                ContextCompat.getColor(this, R.color.cardViewUnSelectedColor)
            )
        }
        binding.bottomSheetParent.layoutSpecificServer.setOnClickListener {
            isFavServerSelected = false
            isSpecificServerSelected = true
            binding.bottomSheetParent.imageSpecser.setColorFilter(
                ContextCompat.getColor(this, R.color.buttonSelectedColor)
            )
            binding.bottomSheetParent.favServerText.setTextColor(
                ContextCompat.getColor(this, R.color.textColor)
            )
            binding.bottomSheetParent.specificServerText.setTextColor(
                ContextCompat.getColor(this, R.color.buttonSelectedColor)
            )
            binding.bottomSheetParent.imagefavser.setColorFilter(
                ContextCompat.getColor(this, R.color.buttonUnSelectedColor)
            )

            binding.bottomSheetParent.layoutFavServer.setCardBackgroundColor(
                ContextCompat.getColor(this, R.color.cardViewUnSelectedColor)
            )
            binding.bottomSheetParent.layoutSpecificServer.setCardBackgroundColor(
                ContextCompat.getColor(this, R.color.cardViewSelectedColor)
            )
        }
    }

    private fun bottomNavigationClickListener() {
        binding.navView.setOnClickListener {

        }
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
        with(binding.bottomSheetParent.serverRecyclers) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@DashBoardActivity)
            adapter = adapterte
        }

        BottomSheetBehavior.from(binding.bottomSheetParent.root).apply {
            skipCollapsed = true
            isHideable = false
            peekHeight = 600
            maxHeight =
                (getDeviceMetrics(this@DashBoardActivity)?.heightPixels?.times(0.75))?.toInt() ?: 0
        }
    }

    override fun onServerNavClicked(type: String) {
        binding.bottomSheetParent.root.isVisible = type.isNotEmpty()
    }

    private fun getDeviceMetrics(context: Context): DisplayMetrics? {
        val metrics = DisplayMetrics()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        display.getMetrics(metrics)
        return metrics
    }

}
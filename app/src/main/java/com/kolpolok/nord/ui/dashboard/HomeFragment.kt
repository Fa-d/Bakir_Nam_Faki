package com.kolpolok.nord.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kolpolok.nord.databinding.FragmentHomeBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapboxMap


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var navChangeListener: NavChangeListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentHomeBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navChangeListener?.onServerNavClicked("Home")
        initView()

    }

    private fun initView() {
        Mapbox.getInstance(requireContext(), "CJohxxcGpBibDmzgcIFH")
        binding.mapView.getMapAsync { map -> loadStyle(map) }
        //binding.mapView.camera
    }

    private fun loadStyle(map: MapboxMap) {
        val styleUrl =
            // "https://api.maptiler.com/maps/cfda6f4a-1d43-4ba7-a1f1-31f2cafd3e7a/style.json?key=${mapTilerKey}";
            "https://api.maptiler.com/maps/openstreetmap/style.json?key=CJohxxcGpBibDmzgcIFH"
        map.setStyle(styleUrl) {
            map.uiSettings.setAttributionMargins(15, 0, 0, 15)
            panToSlopes(map)
        }
    }


    private fun panToSlopes(map: MapboxMap) {
        map.cameraPosition =
            CameraPosition.Builder().target(LatLng(46.98484291, 11.02306368)).zoom(5.0).tilt(0.0)
                .build()
        val latLngBounds = LatLngBounds.Builder().include(LatLng(46.91076825, 10.91279724))
            .include(LatLng(46.98484291, 40.02306368)).build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 100))

    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navChangeListener = context as NavChangeListener
    }

    override fun onDetach() {
        super.onDetach()
        navChangeListener = null
    }
}
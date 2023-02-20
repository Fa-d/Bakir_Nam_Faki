package com.kolpolok.nord.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kolpolok.nord.R

class SettingsFragment : Fragment() {
    private var navChangeListener: NavChangeListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        navChangeListener?.onServerNavClicked("")
        return inflater.inflate(R.layout.fragment_settings, container, false)
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
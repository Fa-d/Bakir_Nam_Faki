package com.kolpolok.octavultvpn.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kolpolok.octavultvpn.databinding.FragmentOnboarding3Binding


class Onboarding3Fragment : Fragment() {
    private lateinit var binding: FragmentOnboarding3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return FragmentOnboarding3Binding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo create new activity
    }
}
package com.kolpolok.octavultvpn.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kolpolok.octavultvpn.R
import com.kolpolok.octavultvpn.databinding.FragmentOnboarding2Binding


class Onboarding2Fragment : Fragment() {

    private lateinit var binding: FragmentOnboarding2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return FragmentOnboarding2Binding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding2Fragment_to_onboarding3Fragment)
        }
    }
}
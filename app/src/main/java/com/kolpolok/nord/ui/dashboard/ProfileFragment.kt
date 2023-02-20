package com.kolpolok.nord.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kolpolok.nord.databinding.FragmentProfileBinding
import com.kolpolok.nord.ui.login.MainActivity


class ProfileFragment : Fragment() {
    private var navChangeListener: NavChangeListener? = null
    private lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        navChangeListener?.onServerNavClicked("")
        return FragmentProfileBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClickListener()
    }

    private fun initClickListener() {
        binding.logoutTV.setOnClickListener {
            requireActivity().finish()
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
    }

    private fun initView() {
        binding.expiryDate.text = "Expire On: 10 Dec 2023"
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
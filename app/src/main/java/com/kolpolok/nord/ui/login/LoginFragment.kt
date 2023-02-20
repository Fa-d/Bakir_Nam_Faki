package com.kolpolok.nord.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kolpolok.nord.core.sealed.GenericState
import com.kolpolok.nord.databinding.FragmentLoginBinding
import com.kolpolok.nord.helpers.Constants
import com.kolpolok.nord.helpers.CountryUtils.getDeviceCountryCode
import com.kolpolok.nord.helpers.UniqueDeviceId
import com.kolpolok.nord.helpers.getRootedState
import com.kolpolok.nord.helpers.getVersion
import com.kolpolok.nord.model.login.LoginRequest
import com.kolpolok.nord.ui.LoginViewModel
import com.kolpolok.nord.ui.dashboard.DashBoardActivity
import com.onesignal.BuildConfig
import com.onesignal.OneSignal
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.json.JSONArray


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClickListener()
    }

    private fun initView() {
        if (BuildConfig.DEBUG) {
            binding.emailET.setText("redtest1")
            binding.passET.setText("redtest1")
        }
    }

/*    private fun initObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is GenericState.Error -> {
                            binding.progressbar.visibility = View.GONE
                            context?.toast(uiState.message)
                        }
                        GenericState.Loading -> {
                            binding.progressbar.visibility = View.VISIBLE
                        }
                        GenericState.None -> {
                            binding.progressbar.visibility = View.GONE
                        }
                        is GenericState.Success -> {
                            // context?.toast(uiState.item.toString())
                            if (uiState.item.responseCode == 1) {
                                observerDatabase()
                                context?.toast("Success")
                            } else if (uiState.item.responseCode == 2) {
                                context?.toast(uiState.item.alertMessage)
                            }
                            binding.progressbar.visibility = View.GONE
                        }
                    }
                }

            }
        }
    }*/

    private fun observerDatabase() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.insertedIntoDB.collect { isInserted ->
                    when (isInserted) {
                        is GenericState.Error -> {}
                        is GenericState.Success -> {
                            requireActivity().startActivity(
                                Intent(requireContext(), DashBoardActivity::class.java)
                            )
                        }
                        is GenericState.Loading -> {}
                        is GenericState.None -> {}
                    }
                }
            }
        }
    }

    private fun initClickListener() {
        binding.loginButton.setOnClickListener {
            val userName = binding.emailET.text.toString().trim()
            val password = binding.passET.text.toString().trim() + Constants.suffix
            viewModel.getLoginDetails(
                LoginRequest(
                    hitUrl = "https://royalvube.echiri.xyz/laravelv5.php",
                    appId = "3",
                    brand = Build.MANUFACTURER,
                    bundle2 = "1",
                    countryCode = getDeviceCountryCode(requireContext()),
                    deviceType = "1",
                    isRooted = getRootedState(),
                    model = Build.MODEL,
                    osName = "Android",
                    osPlatform = Build.CPU_ABI,
                    osVersion = Build.VERSION.RELEASE,
                    rId = "134",
                    rLevel = "4",
                    udid = UniqueDeviceId("redcard") ?: "",
                    username = userName,
                    pass = password,
                    vpnAppVersion = getVersion(requireActivity()),
                    playerId = OneSignal.getDeviceState()?.userId ?: ""
                )
            )
            //    initObserver()
            observerDatabase()
        }
    }

    private fun parseServerArray(serverString: String) {
        var etisalatproServers = ""
        var etisalatServers = ""
        var duServers = ""
        try {
            val array = JSONArray(serverString)
            for (i in 0 until array.length()) {
                val parsedObject = array.getJSONObject(i)
                if (parsedObject != null) {
                    val ip = parsedObject.getString("ip")
                    val network = parsedObject.getInt("network")
                    val type = parsedObject.getInt("connection_type")
                    val sslip = parsedObject.getString("ssl_ip")
                    val platform = parsedObject.getString("platform")
                    val serverType = parsedObject.getInt("type")
                    if ((platform.equals("all", ignoreCase = true) || platform.equals(
                            "android", ignoreCase = true
                        )) && (serverType == 4 || serverType == 2)
                    ) {
                        if (network == 0) {
                            if (type == 2) {
                                etisalatproServers = if (etisalatproServers.isEmpty()) {
                                    sslip
                                } else {
                                    "$etisalatproServers,$sslip"
                                }
                            } else {
                                etisalatServers = if (etisalatServers.isEmpty()) {
                                    ip
                                } else {
                                    "$etisalatServers,$ip"
                                }
                            }
                            duServers = if (duServers.isEmpty()) {
                                ip
                            } else {
                                "$duServers,$ip"
                            }
                        } else if (network == 1) {
                            if (type == 2) {
                                etisalatproServers = if (etisalatproServers.isEmpty()) {
                                    sslip
                                } else {
                                    "$etisalatproServers,$sslip"
                                }
                            } else {
                                etisalatServers = if (etisalatServers.isEmpty()) {
                                    ip
                                } else {
                                    "$etisalatServers,$ip"
                                }
                            }
                        } else if (network == 2) {
                            duServers = if (duServers.isEmpty()) {
                                ip
                            } else {
                                "$duServers,$ip"
                            }
                        }
                    }
                }
            }
            /*        val userDefaults = UserDefaults(getApplicationContext())
                    userDefaults.setShowEtisalatPro(etisalatproServers.isNotEmpty())
                    userDefaults.setShowEtisalat(etisalatServers.isNotEmpty())
                    userDefaults.setShowDu(duServers.isNotEmpty())
                    userDefaults.save()*/
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
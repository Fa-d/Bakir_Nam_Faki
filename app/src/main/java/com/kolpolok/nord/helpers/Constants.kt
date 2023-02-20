package com.kolpolok.nord.helpers

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.os.Build
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Patterns
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.kolpolok.nord.R
import java.util.*


object Constants {
    val BASE_URL = "https://royalvube.echiri.xyz/laravelv5.php/"
    val DB_NAME = "com_kolpolok_bidyanondo"

    val <T> T.exhaustive: T
        get() = this

    val PREF_NAME = "com.kolpolok.bidyanondo"

    val ssps = "Ts(Trjslas"
    val suffix = "-44991221"
    val prefix = "HR4134-"
    val customAppID = "3"
    val deviceType = "1"
    val onSignalId = "46c00520-fe0b-4f35-8f0b-3ad0d70fc5c7"
    val reSellerId = "396"
    val reSellerLevel = "4"
}

fun UniqueDeviceId(str: String?): String? {
    val sb = StringBuilder()
    sb.append(Build.BOARD)
    sb.append("-")
    sb.append(Build.BRAND)
    sb.append("-")
    sb.append(Build.MODEL)
    sb.append("-")
    sb.append(Build.MANUFACTURER)
    sb.append("-")
    sb.append(Build.PRODUCT)
    sb.append("-")
    sb.append(Build.BOOTLOADER)
    sb.append("-")
    sb.append(Build.DISPLAY)
    sb.append("-")
    sb.append(Build.HOST)
    sb.append("-")
    sb.append(Build.ID)
    sb.append("-")
    sb.append(str)
    var sb2 = sb.toString().lowercase(Locale.getDefault())
    try {
        sb2 = sb2.replace("_".toRegex(), "")
    } catch (e: Exception) {
        e.printStackTrace()
    }
    try {
        sb2 = sb2.replace(" ".toRegex(), "")
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return sb2
}

fun getRootedState(): String {
    val buildTags = Build.TAGS
    return if (buildTags != null && buildTags.contains("test-keys")) {
        "1"
    } else {
        "0"
    }
}

fun getVersion(activity: Activity): String {
    return try {
        val pInfo: PackageInfo = activity.packageManager.getPackageInfo(activity.packageName, 0)
        pInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        "N/A"
    }
}

fun Context.toast(msg: String?, time: Int = Toast.LENGTH_SHORT) {
    if (!msg.isNullOrEmpty()) {
        val toast = Toast.makeText(this, msg, time)
        val view: View? = toast.view
        view?.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.black))
        val textView: TextView? = view?.findViewById(android.R.id.message)
        textView?.setTextColor(ContextCompat.getColor(this, R.color.white))
        toast.show()
    }
}

fun Context.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Activity.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()


fun getDeviceMetrics(context: Context): DisplayMetrics? {
    val metrics = DisplayMetrics()
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display: Display = wm.defaultDisplay
    display.getMetrics(metrics)
    return metrics
}

sealed class ViewState {
    object NONE : ViewState()
    data class ShowMessage(val message: String?, val type: Int = 0) : ViewState()
    data class KeyboardState(val isShow: Boolean = false) : ViewState()
    data class ProgressState(val isShow: Boolean = false, val type: Int = 0) : ViewState()
    data class NextState(val type: Int = 0) : ViewState()
    data class EmptyViewState(val type: Int = 0) : ViewState()
}

fun isValidEmail(target: String): Boolean {
    return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
}
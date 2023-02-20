package com.kolpolok.nord.helpers

import android.content.Context
import android.util.Log
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal.OSNotificationWillShowInForegroundHandler
import com.onesignal.OneSignal.OSRemoteNotificationReceivedHandler

class NotificationReceivedHandler : OSNotificationWillShowInForegroundHandler,
    OSRemoteNotificationReceivedHandler {
    var mContext: Context? = null

    constructor()
    constructor(context: Context?) {
        mContext = context
    }

    override fun remoteNotificationReceived(
        context: Context,
        osNotificationReceivedEvent: OSNotificationReceivedEvent
    ) {
        mContext = context
        Log.e("OneSignalExample", "receieved: " + osNotificationReceivedEvent.notification)
        initializeData(osNotificationReceivedEvent)
    }

    override fun notificationWillShowInForeground(osNotificationReceivedEvent: OSNotificationReceivedEvent) {
        initializeData(osNotificationReceivedEvent)
    }

    private fun initializeData(osNotificationReceivedEvent: OSNotificationReceivedEvent) {
        Log.e(
            "OneSignalExample",
            "customkey set with value: " + osNotificationReceivedEvent.notification
        )
        val notification = osNotificationReceivedEvent.notification
        val data = notification.additionalData
        var url: String
        var firebaseHttpUrl: String

/*        if (data != null) {
            String pageName = data.optString("pageControl");
            url = data.optString("url_v2", null);
            firebaseHttpUrl = data.optString("url_firebase", null);
            if (pageName.equalsIgnoreCase("Refresh")) {
                refreshLoginData(mContext);
            }
            if (firebaseHttpUrl != null && !firebaseHttpUrl.equals("")) {
                UserDefaults userDefaults = new UserDefaults(mContext);
                userDefaults.setFirebaseHttpUrl(firebaseHttpUrl);
                userDefaults.save();
            }
            if (url != null) {
                //Log.e("OneSignalExample", "customkey set with value: " + url);

                if (url.startsWith("http://")) {
                    UserDefaults userDefaults = new UserDefaults(mContext);
                    userDefaults.setConfigURL(url);
                    userDefaults.save();
                    //Log.e("OneSignalExample", "saved::" + url);
                }
            }
        }*/
    } /*    private void refreshLoginData(Context context) {
        UserDefaults userDefaults = new UserDefaults(context);
        String resellerId = userDefaults.isFromIran() ? "396" : "134";
//        String url = "http://185.174.110.126/vpn_api_v2_new/public/api_v2/login_v5";
        String url = userDefaults.getConfigURL();


        APIService mApiService = ApiUtils.getAPIService();
        mApiService.login(url, userDefaults.getUserName(), userDefaults.getPassword(), userDefaults.getUdid(), resellerId, "4", Application.getInstance().getDeviceCountryCode(context), Application.getInstance().getVersion(), Build.MANUFACTURER, Build.MODEL, "Android", Build.VERSION.RELEASE, Build.CPU_ABI, Application.getInstance().getRootedState(), "1", "1", Application.getInstance().customAppID, userDefaults.getOneSignalID()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<String>() {
            @Override
            public void onNext(String result) {
                Log.e("login", result);

                if (result != null && !result.equalsIgnoreCase("")) {
                    try {
                        JSONObject obj = new JSONObject(result);
                        String responseCode = obj.getString("response_code");
                        if (responseCode.equals("1")) {
                            String serverIP = obj.getString("server_ip");
                            String duServerIP = obj.getString("server_ip_du");
                            String remainingDays = obj.getString("expire_in_days");
                            Log.e("login", "remainingDays : " + remainingDays);
                            JSONArray ipBundle = obj.getJSONArray("ip_bundle");
                            String validity_date = obj.getString("validity_date");
                            Log.e("login", "validity_date : " + validity_date);
                            if (obj.has("banner_data")) {
                                JSONObject bannerObject = obj.optJSONObject("banner_data");
                                if (bannerObject != null && !bannerObject.equals("")) {
                                    userDefaults.setBannerData(bannerObject.toString());
                                } else userDefaults.setBannerData("");
                            }
                            if (obj.has("dynamic_menu_data")) {
                                JSONObject menuObject = obj.optJSONObject("dynamic_menu_data");
                                if (menuObject != null && !menuObject.equals("")) {
                                    userDefaults.setDynamicMenuData(menuObject.toString());
                                } else userDefaults.setDynamicMenuData("");
                            }
                            if (ipBundle != null && ipBundle.length() > 0) {
                                userDefaults.setServerList(ipBundle.toString());
                                userDefaults.setServer(serverIP);
                                userDefaults.setDuServer(duServerIP);
                                userDefaults.setRemainingDays(remainingDays);
                                userDefaults.setValidity(validity_date);
                                userDefaults.setLoggedIn(true);
                                userDefaults.setShouldAutoLogout(false);
                                userDefaults.save();
                                try {
                                    DemoActivity.instance.updateViewForFirestore();
                                } catch (Exception error) {
                                    error.printStackTrace();
                                }
                            }
                        }

                    } catch (Exception e) {

                    }

                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }*/
}
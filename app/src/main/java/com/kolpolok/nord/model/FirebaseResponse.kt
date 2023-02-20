package com.kolpolok.nord.model

import com.google.firebase.firestore.PropertyName

data class FirebaseResponse(
    @set:PropertyName("appUrl") @get:PropertyName("appUrl") var appUrl: String = "",
    @set:PropertyName("paymentUrl") @get:PropertyName("paymentUrl") var paymentUrl: String = ""
)
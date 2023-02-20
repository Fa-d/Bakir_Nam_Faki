package com.kolpolok.nord.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseManager @Inject constructor(private val firestore: FirebaseFirestore) {
    fun getCollectionData() = firestore.collection("beta").document("apiBaseUrlList")

}

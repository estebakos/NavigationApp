package com.last.shadow.navigationapp.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.last.shadow.navigationapp.model.User

class RegistrationViewModel : ViewModel() {

    private val userNameMutableLiveData = MutableLiveData<String>()
    val userNameLiveData: LiveData<String>
        get() = userNameMutableLiveData

    private val emailMutableLiveData = MutableLiveData<String>()
    val emailLiveData: LiveData<String>
        get() = emailMutableLiveData

    fun saveData(userName: String, email: String) {
        userNameMutableLiveData.value = userName
        emailMutableLiveData.value = email
    }

    fun getUserData(): User {
        return User(userNameMutableLiveData.value!!,
            emailMutableLiveData.value!!)
    }
}
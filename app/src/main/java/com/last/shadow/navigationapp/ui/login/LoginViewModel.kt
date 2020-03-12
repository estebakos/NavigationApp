package com.last.shadow.navigationapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.last.shadow.navigationapp.NavigationProvider

class LoginViewModel : ViewModel(), NavigationProvider<LoginViewModel.LoginView> {

    // CurrentView LiveData
    private val currentViewMutableLiveData = MutableLiveData<Triple<LoginView, LoginView, Any?>>()
    val currentViewLiveData: LiveData<Triple<LoginView, LoginView, Any?>>
        get() = currentViewMutableLiveData

    override fun navigateTo(originView: LoginView, destinationView: LoginView, params: Any?) {
        currentViewMutableLiveData.value = Triple(originView, destinationView, params)
    }

    sealed class LoginView {
        object LoginFragment : LoginView()
        object RegisterFragment : LoginView()
        object ConfirmationFragment : LoginView()
        object ForgotPasswordFragment : LoginView()
        object MainActivity : LoginView()
    }

}
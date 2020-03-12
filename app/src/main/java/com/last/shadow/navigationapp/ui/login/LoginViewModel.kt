package com.last.shadow.navigationapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.last.shadow.navigationapp.NavigationProvider

class LoginViewModel : ViewModel(), NavigationProvider<LoginViewModel.LoginView> {

    // CurrentView LiveData
    private val currentViewMutableLiveData = MutableLiveData<Pair<LoginView, LoginView>>()
    val currentViewLiveData: LiveData<Pair<LoginView, LoginView>>
        get() = currentViewMutableLiveData

    override fun navigateTo(originView: LoginView, destinationView: LoginView) {
        currentViewMutableLiveData.value = Pair(originView, destinationView)
    }

    sealed class LoginView {
        object LoginFragment : LoginView()
        object Register : LoginView()
        object ForgotPasswordFragment : LoginView()
        object MainActivity : LoginView()
    }

}
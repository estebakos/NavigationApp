package com.last.shadow.navigationapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import com.last.shadow.navigationapp.R
import com.last.shadow.navigationapp.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private val registrationViewModel: RegistrationViewModel by navGraphViewModels(R.id.registration_navigation)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrationViewModel.userNameLiveData.observe(viewLifecycleOwner) {
            text_confirmation_user_name.text = getString(R.string.confirmation_user_name, it)
        }

        registrationViewModel.emailLiveData.observe(viewLifecycleOwner) {
            text_confirmation_email.text = getString(R.string.confirmation_email, it)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            loginViewModel.navigateTo(
                LoginViewModel.LoginView.ConfirmationFragment,
                LoginViewModel.LoginView.LoginFragment,
                registrationViewModel.getUserData()
            )
        }
    }
}

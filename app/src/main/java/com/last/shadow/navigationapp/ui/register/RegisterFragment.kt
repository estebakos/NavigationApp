package com.last.shadow.navigationapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.last.shadow.navigationapp.R
import com.last.shadow.navigationapp.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_sign_up.setOnClickListener {
            registrationViewModel.saveData(et_user_name.text.toString(), et_email.text.toString())
            loginViewModel.navigateTo(
                LoginViewModel.LoginView.RegisterFragment,
                LoginViewModel.LoginView.ConfirmationFragment
            )
        }
    }
}

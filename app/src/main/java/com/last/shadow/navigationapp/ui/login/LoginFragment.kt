package com.last.shadow.navigationapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.last.shadow.navigationapp.R
import com.last.shadow.navigationapp.ui.login.LoginViewModel.LoginView
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private val args: LoginFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_login.setOnClickListener {
            loginViewModel.navigateTo(
                LoginView.LoginFragment,
                LoginView.MainActivity
            )
        }

        text_login_register.setOnClickListener {
            loginViewModel.navigateTo(
                LoginView.LoginFragment,
                LoginView.RegisterFragment
            )
        }

        text_login_forgot.setOnClickListener {
            loginViewModel.navigateTo(
                LoginView.LoginFragment,
                LoginView.ForgotPasswordFragment
            )
        }
    }

    override fun onResume() {
        super.onResume()
        if (args.loginParams != null) {
            args.loginParams.let {
                text_login_register.text = "Welcome " + it?.userName
            }
        }
    }

}

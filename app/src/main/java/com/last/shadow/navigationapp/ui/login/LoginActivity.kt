package com.last.shadow.navigationapp.ui.login

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.last.shadow.navigationapp.R
import com.last.shadow.navigationapp.ui.login.LoginViewModel.LoginView

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        navController = findNavController(R.id.nav_login_host_fragment)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.login,
                R.id.registration,
                R.id.forgot_password
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        loginViewModel.currentViewLiveData.observe(this) {
            onViewChange(it)
        }
    }

    private fun onViewChange(navigationEntry: Pair<LoginView, LoginView>) {
        val (origin, destination) = navigationEntry
        when (destination) {
            is LoginView.LoginFragment -> showLoginFragment(origin)
            is LoginView.Register -> showRegisterFragment()
            is LoginView.ForgotPasswordFragment -> showForgotPasswordFragment()
            is LoginView.MainActivity -> showMainActivity()
        }
    }

    private fun showLoginFragment(origin: LoginView) {
        with(navController) {
            when (origin) {
                is LoginView.Register ->
                    navigate(R.id.action_registration_to_login)
                is LoginView.ForgotPasswordFragment ->
                    navigate(R.id.action_forgot_password_to_login)
            }
        }
    }

    private fun showRegisterFragment() {
        navController.navigate(R.id.action_login_to_registration)
    }

    private fun showForgotPasswordFragment() {
        navController.navigate(R.id.action_login_to_forgot_password)
    }

    private fun showMainActivity() {
        navController.navigate(R.id.action_login_to_main_activity)
    }
}

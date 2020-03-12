package com.last.shadow.navigationapp

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.last.shadow.navigationapp.ui.userSelection.UserSelectionViewModel

class UserSelectionActivity : AppCompatActivity() {

    private lateinit var userSelectionViewModel: UserSelectionViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
        setContentView(R.layout.activity_user_selection)

        navController = findNavController(R.id.user_selection_nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.user_selection_fragment, R.id.main_activity
            )
        )

        userSelectionViewModel = ViewModelProvider(this).get(UserSelectionViewModel::class.java)
        userSelectionViewModel.currentViewLiveData.observe(this) {
            onViewChange(it)
        }
    }

    private fun onViewChange(navigationEntry: Triple<UserSelectionViewModel.UserSelectionView, UserSelectionViewModel.UserSelectionView, Any?>) {
        val (origin, destination, params) = navigationEntry
        when (destination) {
            is UserSelectionViewModel.UserSelectionView.UserSelectionFragment -> showUserSelectionFragment(
                origin
            )
            is UserSelectionViewModel.UserSelectionView.MainActivity -> showMainActivity(origin)
            is UserSelectionViewModel.UserSelectionView.ChampionsActivity -> showMainActivity(origin)
        }
    }

    private fun showUserSelectionFragment(origin: UserSelectionViewModel.UserSelectionView) {
    }

    private fun showMainActivity(origin: UserSelectionViewModel.UserSelectionView) {
        navController.navigate(R.id.action_userSelectionFragment_to_main_activity)
    }
}

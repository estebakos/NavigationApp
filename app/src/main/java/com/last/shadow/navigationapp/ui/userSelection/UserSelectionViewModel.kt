package com.last.shadow.navigationapp.ui.userSelection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.last.shadow.navigationapp.NavigationProvider

class UserSelectionViewModel : ViewModel(),
    NavigationProvider<UserSelectionViewModel.UserSelectionView> {

    // CurrentView LiveData
    private val currentViewMutableLiveData =
        MutableLiveData<Triple<UserSelectionView, UserSelectionView, Any?>>()
    val currentViewLiveData: LiveData<Triple<UserSelectionView, UserSelectionView, Any?>>
        get() = currentViewMutableLiveData

    override fun navigateTo(
        originView: UserSelectionView,
        destinationView: UserSelectionView,
        params: Any?
    ) {
        currentViewMutableLiveData.value = Triple(originView, destinationView, params)
    }

    sealed class UserSelectionView {
        object UserSelectionFragment : UserSelectionView()
        object MainActivity : UserSelectionView()
        object ChampionsActivity : UserSelectionView()
    }

}
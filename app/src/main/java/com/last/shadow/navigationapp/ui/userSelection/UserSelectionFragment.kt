package com.last.shadow.navigationapp.ui.userSelection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.last.shadow.navigationapp.R
import kotlinx.android.synthetic.main.fragment_user_selection.*

class UserSelectionFragment : Fragment() {

    private lateinit var userSelectionViewModel: UserSelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSelectionViewModel =
            ViewModelProvider(requireActivity()).get(UserSelectionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_champions.setOnClickListener {
            userSelectionViewModel.navigateTo(
                UserSelectionViewModel.UserSelectionView.UserSelectionFragment,
                UserSelectionViewModel.UserSelectionView.MainActivity
            )
        }
    }
}

package com.zkrallah.task1.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zkrallah.task1.R
import com.zkrallah.task1.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        getActivity()?.let {
            Snackbar.make(
                it.findViewById(android.R.id.content),
                "You Are In Notifications", Snackbar.LENGTH_LONG).show()
        }
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToHome.setOnClickListener {
            findNavController().navigate(R.id.navigation_home)
        }

        binding.goToDashboard.setOnClickListener {
            findNavController().navigate(R.id.navigation_dashboard)
        }

        binding.name.text = arguments?.getString("username") ?: "NO Name Assigned"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.zkrallah.task1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zkrallah.task1.R
import com.zkrallah.task1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        getActivity()?.let {
            Snackbar.make(
                it.findViewById(android.R.id.content),
                "You Are In Home", Snackbar.LENGTH_LONG).show()
        }
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToDashboard.setOnClickListener {
            findNavController().navigate(R.id.navigation_dashboard)
        }

        binding.goToNotification.setOnClickListener {
            findNavController().navigate(R.id.navigation_notifications)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.zkrallah.task1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.zkrallah.task1.R
import com.zkrallah.task1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        getActivity()?.let {
            Snackbar.make(
                it.findViewById(android.R.id.content),
                "You Are In DashBoard", Snackbar.LENGTH_LONG).show()
        }
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = binding.edtName

        binding.goToHome.setOnClickListener {
            findNavController().navigate(R.id.navigation_home)
        }

        binding.goToNotification.setOnClickListener {
            val name = editText.text.toString()
            if (!name.isEmpty()) {
                findNavController().navigate(R.id.navigation_notifications, Bundle().apply {
                    putString("username", name)
                })
            }else{
                Toast.makeText(context,"ASSIGN THE NAME FIRST",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
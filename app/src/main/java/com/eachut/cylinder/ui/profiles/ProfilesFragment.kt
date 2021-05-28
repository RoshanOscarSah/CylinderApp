package com.eachut.cylinder.ui.profiles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eachut.cylinder.databinding.FragmentProfilesBinding
import com.eachut.cylinder.ui.profiles.ProfilesViewModel

class ProfilesFragment : Fragment() {

    private lateinit var profilesViewModel: ProfilesViewModel
    private var _binding: FragmentProfilesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profilesViewModel =
                ViewModelProvider(this).get(ProfilesViewModel::class.java)

        _binding = FragmentProfilesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProfiles
        profilesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
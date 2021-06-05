package com.eachut.cylinder.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eachut.cylinder.R
import com.eachut.cylinder.databinding.FragmentNotificationsBinding
import com.eachut.cylinder.ui.notifications.NotificationsViewModel

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//search
        binding.ivSearchProfiles.setOnClickListener { view ->
            binding.flTab3.isVisible = false
            binding.ivSearchProfiles.isVisible = false
            binding.llsearchBox.isVisible = true
            binding.ivCancalSearchProfiles.isVisible = true
        }

        binding.ivCancalSearchProfiles.setOnClickListener { view ->
            binding.flTab3.isVisible = true
            binding.ivSearchProfiles.isVisible = true
            binding.llsearchBox.isVisible = false
            binding.ivCancalSearchProfiles.isVisible = false
        }

// FILTER
        binding.ivFilterProfiles.setOnClickListener { view ->
            loadPopUpMenu()
        }

//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Load pop up menu image upload
    private fun loadPopUpMenu() {
        val popupMenu = PopupMenu(this.activity, binding.ivFilterProfiles)
        popupMenu.menuInflater.inflate(R.menu.filter_profiles, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.iNameaz ->
                    iNameaz()
                R.id.iNameza ->
                    iNameza()
                R.id.iAmountDue ->
                    iAmountDue()
                R.id.iInactive ->
                    iInactive()
                R.id.iMostSold ->
                    iMostSold()
            }
            true
        }
        popupMenu.show()
    }


}
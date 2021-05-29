package com.eachut.cylinder.ui.home

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eachut.cylinder.R
import com.eachut.cylinder.databinding.FragmentHomeBinding


class   HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//customer/company
        binding.tvCompany.setOnClickListener { view ->
            //for setting gravity
//            val params: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT
//            )
//            params.gravity = Gravity.RIGHT
//            binding.ivToggleActive.setLayoutParams(params);

            //for sliding animation
            ObjectAnimator.ofFloat(binding.ivToggleActive, "translationX", 460f).apply {
                duration = 200
                start()
            }
            binding.tvCustomerOrCompany.setText("Select Company")
            binding.tvCustomerOrCompany.setContentDescription("Select Company")
        }

        binding.tvCustomer.setOnClickListener { view ->
            //for setting gravity
//            val params: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT
//            )
//            params.gravity = Gravity.LEFT
//            binding.ivToggleActive.setLayoutParams(params);

            //for sliding animation
            ObjectAnimator.ofFloat(binding.ivToggleActive, "translationX", 0f).apply {
                duration = 200
                start()
            }
            binding.tvCustomerOrCompany.setText("Select Customer")
            binding.tvCustomerOrCompany.setContentDescription("Select Customer")
        }

//select customer
        binding.llSelectCustomer.setOnClickListener { view ->
            showPopup()
        }




//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showPopup() {
        val inflater: LayoutInflater = this.getLayoutInflater()
        val dialogView: View = inflater.inflate(R.layout.activity_prename, null)

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        dialogBuilder.setOnDismissListener(object : DialogInterface.OnDismissListener {
            override fun onDismiss(arg0: DialogInterface) {

            }
        })
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create();

        alertDialog.show();
        val lp = WindowManager.LayoutParams()

        lp.copyFrom(alertDialog.window!!.attributes)
        lp.height = 1550
        lp.x = 0
        lp.y = 50
        alertDialog.getWindow()!!.setAttributes(lp);
        alertDialog.getWindow()!!.setBackgroundDrawableResource(R.color.dark_fade);
        alertDialog.setCanceledOnTouchOutside(true);


        val llNameSelected = alertDialog.findViewById(R.id.llNameSelected) as LinearLayout
        llNameSelected.setOnClickListener(View.OnClickListener { //do something here
            alertDialog.dismiss()
            val idNameList = llNameSelected.getContentDescription()
            binding.tvCustomerOrCompany.setText(idNameList)
        })


    }
}
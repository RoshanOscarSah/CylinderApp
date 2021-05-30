package com.eachut.cylinder.ui.home

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.core.view.isVisible
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
            binding.tvCustomerOrCompany.setContentDescription("Change Company")
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
            binding.tvCustomerOrCompany.setContentDescription("Change Customer")
        }

//select customer
        binding.llSelectCustomer.setOnClickListener { view ->
            showPopup()
        }

//        call customer
        binding.ivCall.setOnClickListener{ view ->
            val number = binding.ivCall.getContentDescription()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }

//Full HALF EMPTY CYLINDER
        binding.llFullSelected.setOnClickListener{ view ->
//        changing image
            binding.llFullSelectedImg.setImageResource(R.drawable.ic_cylinder_full)
            binding.llHalfSelectedImg.setImageResource(R.drawable.ic_cylinder_half_fade)
            binding.llEmptySelectedImg.setImageResource(R.drawable.ic_cylinder_empty_fade)
//        changing text opacity
            binding.llFullSelectedTxt.setTextColor(Color.parseColor("#FFFFFF"));
            binding.llHalfSelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
            binding.llEmptySelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
        }

        binding.llHalfSelected.setOnClickListener{ view ->
//        changing image
            binding.llFullSelectedImg.setImageResource(R.drawable.ic_cylinder_full_fade)
            binding.llHalfSelectedImg.setImageResource(R.drawable.ic_cylinder_half)
            binding.llEmptySelectedImg.setImageResource(R.drawable.ic_cylinder_empty_fade)
//        changing text opacity
            binding.llFullSelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
            binding.llHalfSelectedTxt.setTextColor(Color.parseColor("#FFFFFF"));
            binding.llEmptySelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
        }

        binding.llEmptySelected.setOnClickListener{ view ->
//        changing image
            binding.llFullSelectedImg.setImageResource(R.drawable.ic_cylinder_full_fade)
            binding.llHalfSelectedImg.setImageResource(R.drawable.ic_cylinder_half_fade)
            binding.llEmptySelectedImg.setImageResource(R.drawable.ic_cylinder_empty_2)
//        changing text opacity
            binding.llFullSelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
            binding.llHalfSelectedTxt.setTextColor(Color.parseColor("#4DFFFFFF"));
            binding.llEmptySelectedTxt.setTextColor(Color.parseColor("#FFFFFF"));
        }

//REGULAR LEAK SOLD CYLINDER
        binding.tvRegular.setOnClickListener{ view ->
            //for sliding animation
            ObjectAnimator.ofFloat(binding.ivRlctoggleActive, "translationX", 0f).apply {
                duration = 200
                start()
            }
        }

        binding.tvLeak.setOnClickListener{ view ->
            //for sliding animation
            ObjectAnimator.ofFloat(binding.ivRlctoggleActive, "translationX", 235f).apply {
                duration = 200
                start()
            }
        }

        binding.tvSold.setOnClickListener{ view ->
            //for sliding animation
            ObjectAnimator.ofFloat(binding.ivRlctoggleActive, "translationX", 470f).apply {
                duration = 200
                start()
            }
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
            val ChangeCustomerOrCompany = binding.tvCustomerOrCompany.getContentDescription()
            binding.tvCustomerOrCompany.setText(ChangeCustomerOrCompany)
            binding.llNameSelected.isVisible = true
        })



    }
}
package com.eachut.cylinder.ui.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eachut.cylinder.databinding.FragmentStockBinding
import com.eachut.cylinder.ui.stock.StockViewModel

class StockFragment : Fragment() {

    private lateinit var stockViewModel: StockViewModel
    private var _binding: FragmentStockBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        stockViewModel =
                ViewModelProvider(this).get(StockViewModel::class.java)

        _binding = FragmentStockBinding.inflate(inflater, container, false)
        val root: View = binding.root

//EDIT STOCK
        binding.flStockEdit.setOnClickListener { view ->
            binding.flStockEditCancal.isVisible = true
            binding.flStockEditDone.isVisible = true
            binding.flStockEdit.isVisible = false

            binding.etPrimaF.setFocusableInTouchMode(true)
            binding.etKamakhyaF.setFocusableInTouchMode(true)
            binding.etSuvidhaF.setFocusableInTouchMode(true)
            binding.etOthersF.setFocusableInTouchMode(true)
            binding.etPrimaH.setFocusableInTouchMode(true)
            binding.etKamakhyaH.setFocusableInTouchMode(true)
            binding.etSuvidhaH.setFocusableInTouchMode(true)
            binding.etOthersH.setFocusableInTouchMode(true)
            binding.etPrimaE.setFocusableInTouchMode(true)
            binding.etKamakhyaE.setFocusableInTouchMode(true)
            binding.etSuvidhaE.setFocusableInTouchMode(true)
            binding.etOthersE.setFocusableInTouchMode(true)
        }

        binding.flStockEditCancal.setOnClickListener { view ->
            binding.flStockEditCancal.isVisible = false
            binding.flStockEditDone.isVisible = false
            binding.flStockEdit.isVisible = true

            binding.etPrimaF.setFocusable(false)
            binding.etKamakhyaF.setFocusable(false)
            binding.etSuvidhaF.setFocusable(false)
            binding.etOthersF.setFocusable(false)
            binding.etPrimaH.setFocusable(false)
            binding.etKamakhyaH.setFocusable(false)
            binding.etSuvidhaH.setFocusable(false)
            binding.etOthersH.setFocusable(false)
            binding.etPrimaE.setFocusable(false)
            binding.etKamakhyaE.setFocusable(false)
            binding.etSuvidhaE.setFocusable(false)
            binding.etOthersE.setFocusable(false)
        }

        binding.flStockEditDone.setOnClickListener { view ->
            binding.flStockEditCancal.isVisible = false
            binding.flStockEditDone.isVisible = false
            binding.flStockEdit.isVisible = true

            binding.etPrimaF.setFocusable(false)
            binding.etKamakhyaF.setFocusable(false)
            binding.etSuvidhaF.setFocusable(false)
            binding.etOthersF.setFocusable(false)
            binding.etPrimaH.setFocusable(false)
            binding.etKamakhyaH.setFocusable(false)
            binding.etSuvidhaH.setFocusable(false)
            binding.etOthersH.setFocusable(false)
            binding.etPrimaE.setFocusable(false)
            binding.etKamakhyaE.setFocusable(false)
            binding.etSuvidhaE.setFocusable(false)
            binding.etOthersE.setFocusable(false)
        }

//        val textView: TextView = binding.textStock
//        stockViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
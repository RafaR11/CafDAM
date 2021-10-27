package com.example.cafdam

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentPrimerBinding

class primerFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentPrimerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = inflate<FragmentPrimerBinding>(inflater,
            R.layout.fragment_primer,container,false)
        binding.button2.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_primerFragment2_to_segonFragment)
        }

        ArrayAdapter.createFromResource(
            requireContext(), R.array.platosPrimero,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerPrimer.adapter = adapter
        }



        return binding.root
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        binding.spinnerPrimer.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    companion object {
        @JvmStatic
        fun newInstance() = primerFragment()
    }
}
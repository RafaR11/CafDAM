package com.example.cafdam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentSegonBinding
import com.example.cafdam.databinding.FragmentTercerBinding

class tercerFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentTercerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTercerBinding>(inflater,
            R.layout.fragment_tercer,container,false)
        binding.buttonFin.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_tercerFragment_to_carritoFragment)
        }
        ArrayAdapter.createFromResource(
            requireContext(), R.array.platosPostre,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerPostre.adapter = adapter
        }

        return binding.root
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        binding.spinnerPostre.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    companion object {
        @JvmStatic
        fun newInstance() = tercerFragment()
    }
}
package com.example.cafdam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentSegonBinding
import com.example.cafdam.databinding.FragmentTercerBinding

class tercerFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var model: carritoViewModel
    private lateinit var binding: FragmentTercerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_tercer,
            container,
            false
        )
        model = ViewModelProvider(requireActivity()).get(carritoViewModel::class.java)
        (activity as AppCompatActivity).supportActionBar?.title = "Postre"
        ArrayAdapter.createFromResource(
            requireContext(), R.array.platosPostre,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerPostre.adapter = adapter
        }
        binding.buttonFin.setOnClickListener{view : View ->
            view.findNavController().navigate(tercerFragmentDirections.actionTercerFragmentToCarritoFragment())
            model.sendPlat3(binding.spinnerPostre.selectedItem.toString())
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
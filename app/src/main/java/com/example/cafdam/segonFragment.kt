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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentPrimerBinding
import com.example.cafdam.databinding.FragmentSegonBinding

class segonFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentSegonBinding
    private lateinit var model: carritoViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSegonBinding>(inflater,
            R.layout.fragment_segon,container,false)
        model = ViewModelProvider(requireActivity()).get(carritoViewModel::class.java)
        (activity as AppCompatActivity).supportActionBar?.title = "Segundo Plato"
        binding.button3.setOnClickListener{view : View ->
            view.findNavController().navigate(segonFragmentDirections.actionSegonFragmentToTercerFragment())
            model.sendPlat2(binding.spinnerSegon.selectedItem.toString())
        }

        ArrayAdapter.createFromResource(
            requireContext(), R.array.platosSegundo,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerSegon.adapter = adapter
        }

        return binding.root
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        binding.spinnerSegon.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    companion object {
        @JvmStatic
        fun newInstance() = segonFragment()
    }
}
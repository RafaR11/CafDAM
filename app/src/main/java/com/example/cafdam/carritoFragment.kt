package com.example.cafdam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentCarritoBinding

class carritoFragment : Fragment() {
    private lateinit var binding: FragmentCarritoBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_carrito,
            container,
            false
        )
        binding.volver.setOnClickListener{view : View ->
            view.findNavController().navigate(carritoFragmentDirections.actionCarritoFragmentToCafesFragment())
            //val args = carritoFragmentArgs.fromBundle(requireArguments())
            //binding.textViewPlat1.text = args.plat1;
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Pedido"

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(carritoViewModel::class.java)
        model.plat.observe(viewLifecycleOwner, Observer {
            binding.textViewPlat1.text = it
        })
        model.plat2.observe(viewLifecycleOwner, Observer {
            binding.textViewPlat2.text = it
        })
        model.plat3.observe(viewLifecycleOwner, Observer {
            binding.textViewPostre.text = it
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() = carritoFragment()
    }
}
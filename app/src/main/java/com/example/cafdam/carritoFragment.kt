package com.example.cafdam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cafdam.databinding.FragmentCarritoBinding

class carritoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCarritoBinding>(inflater,
            R.layout.fragment_carrito,container,false)
        binding.volver.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_carritoFragment_to_cafesFragment)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = carritoFragment()
    }
}
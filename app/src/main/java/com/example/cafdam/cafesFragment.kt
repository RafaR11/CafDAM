package com.example.cafdam

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafdam.databinding.FragmentCafesBinding

class cafesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCafesBinding>(inflater,
            R.layout.fragment_cafes,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Elige tus platos"
        binding.button.setOnClickListener{view : View ->
            view.findNavController().navigate(cafesFragmentDirections.actionCafesFragmentToPrimerFragment2())
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = cafesFragment()
    }
}
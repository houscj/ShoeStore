package com.udacity.shoestore.views.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.setLifecycleOwner(this)

        //default values of newShoe
        binding.newShoe = Shoe("", 0.0, "", "")

        viewModel.isSaved.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
                viewModel.onSavedComplete()
            }

        })

        binding.cancelButton.setOnClickListener{v: View ->
            v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
        }

        return binding.root
    }
}
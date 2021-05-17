package com.udacity.shoestore.views.shoe_listing

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel


class ShoeListingFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        viewModel.listOfShoes.observe(viewLifecycleOwner, Observer { listShoes ->
            for (shoe in listShoes) {

                val shoeItem = layoutInflater.inflate(R.layout.shoe_item, null)
                shoeItem.findViewById<TextView>(R.id.shoe_name_list_item).text = shoe.name
                val companyName =
                    resources.getString(R.string.company_label_shoe_item) + " " + shoe.company
                shoeItem.findViewById<TextView>(R.id.company_name_list_item).text = companyName
                val size =
                    resources.getString(R.string.size_label_shoe_item) + " " + shoe.size.toString()
                shoeItem.findViewById<TextView>(R.id.shoe_size_list_item).text = size
                val description =
                    resources.getString(R.string.description_label_shoe_item) + " " + shoe.description
                shoeItem.findViewById<TextView>(R.id.description_list_item).text = description

                binding.shoeListLinearLayout.addView(shoeItem)
            }
        })

        binding.addShoeFloatingButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.logout_button -> {findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment())
                                    viewModel.resetListOfShoes()}
        }
        return super.onOptionsItemSelected(item)
    }
}
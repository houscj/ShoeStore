package com.udacity.shoestore.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false)
        binding.loginButton.setOnClickListener { v: View ->
            checkInformations(v)
        }

        binding.signUpButton.setOnClickListener { v: View ->
            checkInformations(v)
        }

        return binding.root
    }

    private fun checkInformations(v: View) {
        if (binding.edtEmailAdress.text.toString().trim().isEmpty() || binding.edtPassword.text.toString().trim().isEmpty())
            Toast.makeText(context, context?.getString(R.string.login_error), Toast.LENGTH_SHORT).show()
        else
            v.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }


}
package com.example.marvelheroes.ui.signin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.marvelheroes.R
import com.example.marvelheroes.databinding.FragmentSignInBinding
import com.example.marvelheroes.presentation.UserViewModel
import com.facebook.CallbackManager
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SigInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding
    private val callbackManager = CallbackManager.Factory.create()
    private val viewModel by viewModels<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)

        binding.btnFacebook.setOnClickListener {
            viewModel.doLoginFacebook(callbackManager, this)
        }

        viewModel.user.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_sigInFragment_to_heroesFragment)
            Log.e("a","$it")
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}
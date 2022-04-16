package com.example.marvelheroes.ui.signin

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.marvelheroes.R
import com.example.marvelheroes.application.AppConstants
import com.example.marvelheroes.data.model.User
import com.example.marvelheroes.databinding.FragmentSignInBinding
import com.example.marvelheroes.presentation.UserViewModel
import com.facebook.CallbackManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
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
        binding.btnGoogle.setOnClickListener {
            viewModel.doLoginGoogle(this)
        }

        viewModel.is_saved_user.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().navigate(R.id.action_sigInFragment_to_heroesFragment)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == AppConstants.RC_GOOGLE_SIGNING && data!= null && resultCode == RESULT_OK){
            val task : Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            saveGoogleUser(task)
        }else{
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun saveGoogleUser(task : Task<GoogleSignInAccount>){
        val account = task.getResult(ApiException::class.java)
        val user = User(
            account.id.toString(),
            account.givenName,
            account.familyName,
            account.email,
            account.photoUrl.toString(),
            "Google"
        )
        viewModel.saveUser(user)
       // Log.e("acountData", accountData.email.toString())
    }
}
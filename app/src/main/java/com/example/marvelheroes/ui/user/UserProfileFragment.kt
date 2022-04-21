package com.example.marvelheroes.ui.user

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import coil.load
import com.example.marvelheroes.R
import com.example.marvelheroes.application.Prefs
import com.example.marvelheroes.core.loadDialog
import com.example.marvelheroes.core.toolbar
import com.example.marvelheroes.data.DialogType
import com.example.marvelheroes.databinding.FragmentUserProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    private lateinit var bindig: FragmentUserProfileBinding
    @Inject lateinit var prefs: Prefs
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindig = FragmentUserProfileBinding.bind(view)
        activity?.toolbar(bindig.toolbar)
        setProfileData()
        //show item toolbar
        setHasOptionsMenu(true)
    }
    private fun setProfileData(){
        bindig.imgProfile.load(prefs.getUrlProfile())
        bindig.txtName.text = prefs.getName()
        bindig.txtLastName.text = prefs.getLastName()
        bindig.txtEmail.text = prefs.getEmail()
        if(prefs.getSignInType()=="Facebook"){
            bindig.imgSignInType.setImageResource(R.drawable.facebook)
        }else{
            bindig.imgSignInType.setImageResource(R.drawable.gmail)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itemExit -> {
                this.loadDialog(getString(R.string.dialog_close_app),DialogType.CLOSE_APP ,prefs)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
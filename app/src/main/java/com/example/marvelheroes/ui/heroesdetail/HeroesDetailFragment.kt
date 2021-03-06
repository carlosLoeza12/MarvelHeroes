package com.example.marvelheroes.ui.heroesdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.marvelheroes.R
import com.example.marvelheroes.core.toolbar
import com.example.marvelheroes.databinding.FragmentHeroesDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesDetailFragment : Fragment(R.layout.fragment_heroes_detail) {

    private lateinit var binding: FragmentHeroesDetailBinding
    private val args by navArgs<HeroesDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroesDetailBinding.bind(view)

        setData()
        activity?.toolbar(binding.toolbar)
        initButtons()
    }

    private fun setData(){
        binding.imgHeroe.load(args.currentHeroe.urmImg)
        binding.txtHeroeName.text = args.currentHeroe.name
        binding.txtDescription.text = args.currentHeroe.description

    }

    private fun initButtons(){

        binding.btnSeries.setOnClickListener {
            findNavController().navigate(
                HeroesDetailFragmentDirections.actionHeroesDetailFragmentToHeroExtraInfoFragment(args.currentHeroe.id))
        }
        binding.btnEvents.setOnClickListener {
            findNavController().navigate(
                HeroesDetailFragmentDirections.actionHeroesDetailFragmentToHeroExtraInfoFragment(args.currentHeroe.id))
        }
    }

}
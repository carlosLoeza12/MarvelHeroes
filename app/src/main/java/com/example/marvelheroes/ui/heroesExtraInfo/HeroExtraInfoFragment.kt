package com.example.marvelheroes.ui.heroesExtraInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelheroes.R
import com.example.marvelheroes.core.toolbar
import com.example.marvelheroes.databinding.FragmentHeroExtraInfoBinding
import com.example.marvelheroes.ui.adapters.HeroesCollectionAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroExtraInfoFragment : Fragment(R.layout.fragment_hero_extra_info) {

    private lateinit var binding: FragmentHeroExtraInfoBinding
    private lateinit var heroExtraAdapter: HeroesCollectionAdapter
    private val args by navArgs<HeroExtraInfoFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroExtraInfoBinding.bind(view)

        activity?.toolbar(binding.toolbar)
        setRecycler()
    }
    private fun setRecycler() {
        if(args.itemCollections.items.isNullOrEmpty())
            binding.imgNA.isVisible = true
        else {
            heroExtraAdapter = HeroesCollectionAdapter(args.itemCollections.items)
            binding.recyclerCollections.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = heroExtraAdapter
            }
        }
    }
}
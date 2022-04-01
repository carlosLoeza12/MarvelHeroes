package com.example.marvelheroes.ui.heroesExtraInfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelheroes.R
import com.example.marvelheroes.core.toolbar
import com.example.marvelheroes.databinding.FragmentHeroExtraInfoBinding
import com.example.marvelheroes.presentation.HeroesViewModel
import com.example.marvelheroes.ui.adapters.HeroesCollectionAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroExtraInfoFragment : Fragment(R.layout.fragment_hero_extra_info) {

    private lateinit var binding: FragmentHeroExtraInfoBinding
    private val args by navArgs<HeroExtraInfoFragmentArgs>()
    private val viewModel by activityViewModels<HeroesViewModel>()
    private lateinit var heroExtraAdapter: HeroesCollectionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroExtraInfoBinding.bind(view)

        activity?.toolbar(binding.toolbar)
        viewModel.getListSeriesByHeroe(args.idHeroe)
        viewModel.isLoadingSeries.observe(viewLifecycleOwner, Observer {
            binding.progress.isVisible = it
        })

        setRecycler()
    }
    private fun setRecycler() {

        viewModel.listHeroesSeries.observe(viewLifecycleOwner, Observer {listSeries ->
            if(listSeries.isNullOrEmpty()) {
                binding.imgNA.isVisible = true
            }
            else {
                binding.imgNA.isVisible = false
                heroExtraAdapter = HeroesCollectionAdapter(listSeries)
                binding.recyclerCollections.apply {
                    heroExtraAdapter = HeroesCollectionAdapter(listSeries)
                    layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    adapter = heroExtraAdapter
                }
            }
        })
    }

    override fun onStop() {
        binding.recyclerCollections.adapter = HeroesCollectionAdapter(emptyList())
        viewModel.listHeroesSeries.postValue(emptyList())
        super.onStop()
    }

}
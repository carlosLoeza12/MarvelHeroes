package com.example.marvelheroes.ui.heroes

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelheroes.R
import com.example.marvelheroes.data.model.Heroe
import com.example.marvelheroes.databinding.FragmentHeroesBinding
import com.example.marvelheroes.presentation.HeroesViewModel
import com.example.marvelheroes.ui.adapters.HeroesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment : Fragment(R.layout.fragment_heroes),HeroesAdapter.OnHeroesClickListener {

    private lateinit var binding: FragmentHeroesBinding
    private lateinit var heroesAdapter: HeroesAdapter
    private val viewModel by activityViewModels<HeroesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroesBinding.bind(view)

        viewModel.getListHeroes()
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        observersViewModels()
        //show item toolbar
        setHasOptionsMenu(true);

    }

    private fun observersViewModels() {
        viewModel.listHeroes.observe(viewLifecycleOwner, Observer {
            setRecycler(it)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun setRecycler(list: List<Heroe>) {

        heroesAdapter = HeroesAdapter(list, this)
        binding.recyclerHeroes.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = heroesAdapter
            scrollToPosition(viewModel.positionRecycler.value ?:0)
        }

    }

    override fun onHeroesClick(heroe: Heroe, position: Int) {
        viewModel.positionRecycler.postValue(position)

        val action = HeroesFragmentDirections.actionHeroesFragmentToHeroesDetailFragment(
            heroe
        )
        findNavController().navigate(action)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_heroe, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itemSave -> {
                // preferencessss.wipe()
                // findNavController().navigate(R.id.action_heroesFragment_to_searchHeroeFragment)
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
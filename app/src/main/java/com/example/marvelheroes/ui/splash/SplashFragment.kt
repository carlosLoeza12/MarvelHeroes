package com.example.marvelheroes.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.marvelheroes.R
import com.example.marvelheroes.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        binding.imgLogo.startAnimation(animation)
        timerSplash()
    }

    private fun timerSplash() {

        val timer = object : CountDownTimer(1700, 1000) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_sigInFragment)
            }
        }
        timer.start()

    }
}
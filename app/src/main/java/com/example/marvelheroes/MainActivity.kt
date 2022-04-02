package com.example.marvelheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.marvelheroes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*It's very important to set the toolbar to prevent errors of the NPE type,
         this is because the application style is .NoActionBar
         setSupportActionBar(binding.toolbar)
         binding.toolbar.navigationIcon?.setTint(resources.getColor(R.color.white))

         navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
         NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)

         */
    }
}
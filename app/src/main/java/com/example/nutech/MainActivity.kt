package com.example.nutech

import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.nutech.databinding.ActivityMainBinding
import com.example.nutech.extension.startAnimation
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    /*
    * variables
    * */
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        showExplodeAnim()


    }


    /*
    *
    * init bottom view
    * */
    private fun initialize() {


        /*
        * setting navHost fragment
        * */
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        /*
        * bottom navigation property
        * */
        bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.apply {
            background = null
            menu.getItem(3).isEnabled = false
            setupWithNavController(navController)
        }


        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.more, R.id.explore, R.id.favorite -> {
                    binding.isVisible = true
                }
                else -> {
                    binding.isVisible = false
                }
            }
        }
    }


    /*
    * fab explode animation
    * */
    private fun showExplodeAnim() {
        binding.fab.setOnClickListener {

            val animation =
                AnimationUtils.loadAnimation(this, R.anim.circle_explosion_animation)
                    .apply {
                        duration = 700
                        interpolator = AccelerateDecelerateInterpolator()
                    }
            binding.isVisible = false
            binding.animationView.startAnimation(animation) {
                binding.isVisible = true
                navController.navigate(R.id.searchFragment)
            }
        }
    }
}
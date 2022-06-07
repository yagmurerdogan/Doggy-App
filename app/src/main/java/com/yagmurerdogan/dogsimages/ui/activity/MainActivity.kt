package com.yagmurerdogan.dogsimages.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.yagmurerdogan.dogsimages.R
import com.yagmurerdogan.dogsimages.databinding.ActivityMainBinding
import com.yagmurerdogan.dogsimages.utils.extensions.closeCheckable
import com.yagmurerdogan.dogsimages.utils.extensions.openCheckable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.bottomNavView) {
            closeCheckable()
            background = null
            menu.getItem(1).isEnabled = false
            itemIconTintList = null
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavView, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.favoritesFragment || destination.id == R.id.bookmarkFragment) {
                with(binding.bottomNavView) {
                    openCheckable()
                }
            }
        }

        binding.fab.setOnClickListener {
            binding.bottomNavView.closeCheckable()
            navHostFragment.navController.navigate(R.id.toDogFragment)
        }
    }
}

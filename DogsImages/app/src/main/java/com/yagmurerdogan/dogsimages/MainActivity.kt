package com.yagmurerdogan.dogsimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.yagmurerdogan.dogsimages.databinding.ActivityMainBinding
import com.yagmurerdogan.dogsimages.utils.extensions.setInvisible
import com.yagmurerdogan.dogsimages.utils.extensions.setVisible

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.bottomNavView) {
            background = null
            menu.getItem(1).isEnabled = false
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavView, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.splashFragment -> binding.bottomNavView.setInvisible()
                else -> binding.bottomNavView.setVisible()
            }
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

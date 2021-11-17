package com.yagmurerdogan.dogsimages

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yagmurerdogan.dogsimages.databinding.ActivityMainBinding
import com.yagmurerdogan.dogsimages.repository.Repository
import com.yagmurerdogan.dogsimages.utils.extensions.load
import com.yagmurerdogan.dogsimages.utils.extensions.setInvisible
import com.yagmurerdogan.dogsimages.utils.extensions.setVisible

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}

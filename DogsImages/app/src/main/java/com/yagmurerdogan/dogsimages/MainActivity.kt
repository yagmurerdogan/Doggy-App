package com.yagmurerdogan.dogsimages

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yagmurerdogan.dogsimages.api.SimpleApi
import com.yagmurerdogan.dogsimages.databinding.ActivityMainBinding
import com.yagmurerdogan.dogsimages.model.ApiModel
import com.yagmurerdogan.dogsimages.repository.Repository
import com.yagmurerdogan.dogsimages.utils.Constants.Companion.BASE_URL
import com.yagmurerdogan.dogsimages.utils.load
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        backgroundAnimation()

        setImage()

        binding.floatingActionButton.setOnClickListener {

            // FAB rotate animation
            binding.floatingActionButton.animate().apply {
                rotationBy(360f)
                duration = 1000
            }.start()

            setImage()
            binding.ivRandomDog.visibility = View.GONE

        }
    }

    private fun backgroundAnimation() {
        val animationDrawable: AnimationDrawable = binding.rlLayout.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }

    private fun setImage() {
        viewModel.getDogImage()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful) {
                binding.ivRandomDog.load(response.body()?.url.toString(),applicationContext)
                Log.e("Response", response.body()?.url.toString())
                Log.e("Response", response.body()?.status.toString())
            } else {
                Log.e("Response",response.errorBody().toString())
            }
        })
    }
}

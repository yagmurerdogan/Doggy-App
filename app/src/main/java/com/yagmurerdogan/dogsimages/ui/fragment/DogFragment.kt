package com.yagmurerdogan.dogsimages.ui.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yagmurerdogan.dogsimages.DogFragmentViewModel
import com.yagmurerdogan.dogsimages.DogViewModelFactory
import com.yagmurerdogan.dogsimages.databinding.FragmentDogBinding
import com.yagmurerdogan.dogsimages.repository.Repository
import com.yagmurerdogan.dogsimages.ui.base.BaseFragment
import com.yagmurerdogan.dogsimages.utils.extensions.load
import com.yagmurerdogan.dogsimages.utils.extensions.setVisible

class DogFragment : BaseFragment<FragmentDogBinding>(FragmentDogBinding::inflate) {

    private lateinit var viewModel: DogFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = DogViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[DogFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        backgroundAnimation()
        setImage()
    }

    private fun backgroundAnimation() {
        val animationDrawable: AnimationDrawable =
            binding.fragmentDog.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(3000)
            start()
        }
    }

    private fun setImage() {
        viewModel.getDogImage()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                with(binding.ivRandomDog) {
                    load(response.body()?.url.toString(), requireContext())
                    setVisible()
                }
                Log.e("Response", response.body()?.status.toString())
            } else {
                Log.e("Response", response.errorBody().toString())
            }
        })
    }
}
package com.yagmurerdogan.dogsimages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yagmurerdogan.dogsimages.repository.Repository

class DogViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DogFragmentViewModel(repository) as T
    }
}
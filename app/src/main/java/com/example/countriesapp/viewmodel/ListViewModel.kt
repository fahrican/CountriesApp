package com.example.countriesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countriesapp.model.CountriesService
import com.example.countriesapp.model.Country
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {

    val countriesService = CountriesService()
    val disposable = CompositeDisposable()

    // LiveData
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true
        disposable.add(
            countriesService.getCountries()
                .subscribeOn(Schedulers.newThread()) // processing on a separate thread
                .observeOn(AndroidSchedulers.mainThread()) // show result on main-thread, is the thread which the user see
                .subscribeWith( // what happens when we receive the information
                    object : DisposableSingleObserver<List<Country>>() {

                        override fun onSuccess(value: List<Country>?) {
                            countries.value = value
                            countryLoadError.value = false
                            loading.value = false
                        }

                        override fun onError(e: Throwable?) {
                            countryLoadError.value = true
                            loading.value = false
                        }
                    })
        )
    }
}
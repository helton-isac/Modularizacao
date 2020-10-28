package com.hitg.modularizacao.ui.main

import androidx.lifecycle.MutableLiveData
import com.hitg.domain.entity.Product
import com.hitg.domain.usecases.GetProductsUseCase
import com.hitg.modularizacao.viewmodel.BaseViewModel
import com.hitg.modularizacao.viewmodel.StateMachineSingle
import com.hitg.modularizacao.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    val useCase: GetProductsUseCase,
    val uiScheduler: Scheduler
) : BaseViewModel() {
    val state = MutableLiveData<ViewState<List<Product>>>().apply {
        value = ViewState.Loading
    }

    fun getProducts(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }
}
package br.com.arquiteturamvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mRespository = PersonRepository()

    private var mTextWelcome = MutableLiveData<String>()
    var textWelCome = mTextWelcome

    private var mLogin =  MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Hello Word"
    }

    fun login(login: String) {
        val result = mRespository.login(login)
        mLogin.value = result
    }

}
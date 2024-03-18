package com.cidadelimpa.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _cpf = MutableLiveData<String>()
    val cpf: LiveData<String> = _cpf

    fun onCpfChange(newCpf: String)
    {
        val maxLength = 11

        if (newCpf.length <= maxLength)
        {
            _cpf.value = newCpf.replace(
                regex = Regex(pattern = "[^0-9]"),
                replacement = ""
            )
        }
    }

    private val _pwd = MutableLiveData<String>()
    val pwd: LiveData<String> = _pwd

    fun onPwdChange(newPwd: String)
    {
        val maxLength = 8

        if (newPwd.length <= maxLength)
        {
            _pwd.value = newPwd.replace(
                regex = Regex(pattern = "[^0-9]"),
                replacement = ""
            )
        }
    }
}
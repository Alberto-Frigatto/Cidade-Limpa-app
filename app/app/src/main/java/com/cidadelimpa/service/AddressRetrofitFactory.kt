package com.cidadelimpa.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRetrofitFactory {

    private val URL = "https://viacep.com.br/ws/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAddressService(): AddressService {
        return retrofitFactory.create(AddressService::class.java)
    }

}
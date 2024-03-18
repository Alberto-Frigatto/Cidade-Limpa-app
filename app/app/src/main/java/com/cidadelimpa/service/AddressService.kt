package com.cidadelimpa.service

import com.cidadelimpa.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("{cep}/json/")
    fun getAddressByCep(@Path("cep") cep: String): Call<Address>
}
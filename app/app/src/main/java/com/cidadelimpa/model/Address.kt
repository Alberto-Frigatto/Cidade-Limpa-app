package com.cidadelimpa.model

import com.google.gson.annotations.SerializedName

data class Address(
    val logradouro: String = "",
    @SerializedName("localidade") val cidade: String = "",
    val bairro: String = "",
    val uf: String = ""
)
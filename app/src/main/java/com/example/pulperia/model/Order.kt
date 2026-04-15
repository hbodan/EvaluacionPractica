package com.example.pulperia.model

// Modelo de datos simple para representar el pedido
data class Order(
    val id: Long = System.currentTimeMillis(),
    val clientName: String,
    val productName: String,
    val quantity: String
)
package com.example.pulperia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tuempresa.pulperia.model.Order
import com.tuempresa.pulperia.ui.components.ModernInput
import com.tuempresa.pulperia.ui.components.OrderResultCard

@Composable
fun OrderScreen() {
    // Estados internos con remember
    var name by remember { mutableStateOf("") } // Podrías inicializar con "Harry Bodan" para probar
    var product by remember { mutableStateOf("") }
    var qty by remember { mutableStateOf("") }
    var lastOrder by remember { mutableStateOf<Order?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text("Pedido de", fontSize = 24.sp, color = Color.Gray)
        Text("Pulpería.", fontSize = 40.sp, fontWeight = FontWeight.Black, color = Color.Black)

        Spacer(modifier = Modifier.height(32.dp))

        ModernInput(name, { name = it }, "Nombre del Cliente", Icons.Rounded.Person)
        Spacer(modifier = Modifier.height(16.dp))
        ModernInput(product, { product = it }, "¿Qué producto necesita?", Icons.Rounded.ShoppingCart)
        Spacer(modifier = Modifier.height(16.dp))
        ModernInput(qty, { qty = it }, "Cantidad", Icons.Rounded.AddCircle)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if(name.isNotBlank() && product.isNotBlank()) {
                    lastOrder = Order(clientName = name, productName = product, quantity = qty)
                }
            },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("Registrar ahora", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Mostrar el pedido solo si existe uno registrado
        lastOrder?.let {
            OrderResultCard(it.clientName, it.productName, it.quantity)
        }
    }
}
package com.nunez.abraham.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nunez.abraham.laboratoriocalificado02.databinding.ActivityEjercicio02DatosBinding

class Ejercicio02Datos : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02DatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02DatosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()
        intent.extras?.let {
            showData(it)
        }

    }
    private fun showData(paramsExtras: Bundle){
        val nombres = intent.getStringExtra("NOMBRES")
        val numero = intent.getStringExtra("NUMERO")
        val productos = intent.getStringExtra("PRODUCTOS")
        val ciudad = intent.getStringExtra("CIUDAD")
        val direccion = intent.getStringExtra("DIRECCION")

        binding.usuario.text = nombres
        binding.telefono.text = numero
        binding.producto.text = productos
        binding.ubicacion.text = ciudad + ", " + direccion
    }

    private fun listenerComponentUi() {
        binding.btnLlamar.setOnClickListener {
            Call()
        }
        binding.btnWsp.setOnClickListener {
            WhatsappMessage()
        }
        binding.btnMaps.setOnClickListener {
            Maps()
        }

    }

    private fun WhatsappMessage() {
        val nombreCliente = "Nombre Cliente"
        val productos = binding.producto.text.toString()
        val direccion = binding.ubicacion.text.toString()
        val numeroCliente = binding.telefono.text.toString()
        val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"

        if (numeroCliente.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$numeroCliente&text=${Uri.encode(mensaje)}")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Por favor ingresa un número de teléfono válido", Toast.LENGTH_SHORT).show()
        }
    }
    private fun Call() {
        val phoneNumber = binding.telefono.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)
    }
    private fun Maps() {
        val location = binding.ubicacion.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:0,0?q=$location")
        startActivity(intent)
    }

}
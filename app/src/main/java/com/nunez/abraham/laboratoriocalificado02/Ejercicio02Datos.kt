package com.nunez.abraham.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
        val phoneNumber = binding.usuario.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
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
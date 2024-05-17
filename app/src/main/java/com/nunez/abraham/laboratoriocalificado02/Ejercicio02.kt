package com.nunez.abraham.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nunez.abraham.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnRegistrar.setOnClickListener {
            val nombres = binding.nombres.text.toString()
            val numero = binding.numero.text.toString()
            val productos = binding.productos.text.toString()
            val ciudad = binding.ciudad.text.toString()
            val direccion = binding.direction.text.toString()

            val intent = Intent(this, Ejercicio02Datos::class.java).apply {
                putExtra("NOMBRES", nombres)
                putExtra("NUMERO", numero)
                putExtra("PRODUCTOS", productos)
                putExtra("CIUDAD", ciudad)
                putExtra("DIRECCION", direccion)
            }
            startActivity(intent)
        }
    }
}
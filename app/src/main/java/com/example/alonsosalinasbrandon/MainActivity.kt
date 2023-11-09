package com.example.alonsosalinasbrandon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var kilometros: EditText
    private lateinit var spAutos: Spinner
    private lateinit var btnResultados: Button
    private lateinit var tvNovalido: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kilometros = findViewById(R.id.kilometros)
        spAutos = findViewById(R.id.spAutos)
        btnResultados = findViewById(R.id.btnResultado)
        tvNovalido = findViewById(R.id.tvNotValido)

        val Autos = arrayOf("Selecciona una Marca",
            "Nissan",
            "Kia",
            "BMW"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, Autos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAutos.adapter = adaptador

        spAutos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

               btnResultados.setOnClickListener{
                   if (kilometros.text.isEmpty()){
                       tvNovalido.text = "Debes Ingresar el numero de kilometros"
                   } else {

                       val kl = kilometros.text.toString().toInt()
                   var costoxkilo = when{
                       position == 1 -> 25
                       position == 2 -> 35
                       else -> 70
                   }
                   var total = costoxkilo * kl
                       val intent = Intent(this@MainActivity, ResultsActivity2::class.java)
                       intent.putExtra("Monto total", total)
                       startActivity(intent)


                   }
               }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}
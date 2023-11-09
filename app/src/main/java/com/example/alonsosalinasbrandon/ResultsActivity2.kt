package com.example.alonsosalinasbrandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsActivity2 : AppCompatActivity() {

    private lateinit var tvResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results2)

        tvResults = findViewById(R.id.tvResults)

        val total = intent.getIntExtra("Monto total", 0)
        tvResults.text = "El total A pagar es de $total"
    }
}
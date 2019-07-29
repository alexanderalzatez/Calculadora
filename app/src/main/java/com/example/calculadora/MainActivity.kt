package com.example.calculadora

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue
import kotlin.math.exp

class MainActivity : AppCompatActivity() {

    private var expresion = ""
    private var operador1 = 0.0
    private var operador2 = 0.0
    private var operacion = 's'
    private var resultado = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //***************************Se obtienen los números**********************
        //************************************************************************
        tvCero.setOnClickListener {
           // tvCero.setBackgroundColor(Color.BLUE)
            expresion += tvCero.text.toString()
            tvExpresion.text  = expresion
        }
        tvUno.setOnClickListener {
            expresion += tvUno.text.toString()
            tvExpresion.text  = expresion
        }
        tvDos.setOnClickListener {
            expresion += tvDos.text.toString()
            tvExpresion.text  = expresion
        }
        tvTres.setOnClickListener {
            expresion += tvTres.text.toString()
            tvExpresion.text  = expresion
        }
        tvCuatro.setOnClickListener {
            expresion += tvCuatro.text.toString()
            tvExpresion.text  = expresion
        }
        tvCinco.setOnClickListener {
            expresion += tvCinco.text.toString()
            tvExpresion.text  = expresion
        }
        tvSeis.setOnClickListener {
            expresion += tvSeis.text.toString()
            tvExpresion.text  = expresion
        }
        tvSiete.setOnClickListener {
            expresion += tvSiete.text.toString()
            tvExpresion.text  = expresion
        }
        tvOcho.setOnClickListener {
            expresion += tvOcho.text.toString()
            tvExpresion.text  = expresion
        }
        tvNueve.setOnClickListener {
            expresion += tvNueve.text.toString()
            tvExpresion.text  = expresion
        }

        //***************************Operaciones***********************************
        //************************************************************************
        tvSuma.setOnClickListener {
            try {
                operador1 = expresion.toDouble()
                expresion += tvSuma.text.toString()
                operacion = 's'
                tvExpresion.text = expresion
            }catch (e:Exception){
                Log.d("Exception","message : "+e.message)
                Toast.makeText(this,"Ingresa el operando",Toast.LENGTH_SHORT).show()
            }

        }
        
        tvResta.setOnClickListener {
            try {
                operador1 = expresion.toDouble()
                expresion += tvResta.text.toString()
                operacion = 'r'
                tvExpresion.text = expresion
            }catch (e:Exception){
                Log.d("Exception","message : "+e.message)
                Toast.makeText(this,"Ingresa el operando",Toast.LENGTH_SHORT).show()
            }
        }
        tvMultiplicacion.setOnClickListener {
            try {
                operador1 = expresion.toDouble()
                expresion += tvMultiplicacion.text.toString()
                operacion = 'm'
                tvExpresion.text = expresion
            }catch (e:Exception){
                Log.d("Exception","message : "+e.message)
                Toast.makeText(this,"Ingresa el operando",Toast.LENGTH_SHORT).show()
            }
        }

        tvDivision.setOnClickListener {
            try {
                operador1 = expresion.toDouble()
                expresion += tvDivision.text.toString()
                operacion = 'd'
                tvExpresion.text = expresion
            }catch (e:Exception){
                Log.d("Exception","message : "+e.message)
                Toast.makeText(this,"Ingresa el operando",Toast.LENGTH_SHORT).show()
            }
        }

        tvBorrar.setOnClickListener {
            expresion = tvExpresion.text.toString()
            if(expresion.isNotEmpty()){
                expresion = expresion.substring(0,expresion.length-1)
                tvExpresion.text = expresion
            }
            tvResultado.text =""
        }
        tvCe.setOnClickListener {
            expresion = ""
            tvExpresion.text = expresion
            tvResultado.text = expresion
        }

        tvPunto.setOnClickListener {
            expresion += tvPunto.text.toString()
            tvExpresion.text = expresion
        }

        /*tvOpenParent.setOnClickListener {
            //tvExpresion.text = tvOpenParent.text.toString() + expresion
            expresion += tvOpenParent.text.toString()
            tvExpresion.text  = expresion
        }

        tvCloseParent.setOnClickListener {
            //tvExpresion.text = expresion + tvCloseParent.text.toString()
            expresion += tvCloseParent.text.toString()
            tvExpresion.text  = expresion
        }
        */
        tvIgual.setOnClickListener {
            try{
                when(operacion){
                    's'-> {
                        val separar = expresion.split(tvSuma.text.toString())
                        operador2 = separar[1].toDouble()
                        resultado=operador1+operador2
                        if((resultado.toInt()-resultado).absoluteValue != 0.0)
                            tvResultado.text = resultado.toString()
                        else
                            tvResultado.text = resultado.toInt().toString()
                    }
                    'r' -> {
                        val separar = expresion.split(tvResta.text.toString())
                        operador2 = separar[1].toDouble()
                        resultado=operador1-operador2
                        if((resultado.toInt()-resultado).absoluteValue != 0.0)
                            tvResultado.text = resultado.toString()
                        else
                            tvResultado.text = resultado.toInt().toString()
                    }
                    'm' -> {
                        val separar = expresion.split(tvMultiplicacion.text.toString())
                        operador2 = separar[1].toDouble()
                        resultado=operador1*operador2
                        if((resultado.toInt()-resultado).absoluteValue != 0.0)
                            tvResultado.text = resultado.toString()
                        else
                            tvResultado.text = resultado.toInt().toString()
                    }
                    'd' -> {
                        val separar = expresion.split(tvDivision.text.toString())
                        operador2 = separar[1].toDouble()
                        if(operador2 != 0.0) {
                            resultado = operador1 / operador2
                            if((resultado.toInt()-resultado).absoluteValue != 0.0)
                                tvResultado.text = resultado.toString()
                            else
                                tvResultado.text = resultado.toInt().toString()
                        }else{
                            tvResultado.text = "División por cero!"
                            tvExpresion.text = "math error!"
                        }
                    }
                }
            }
            catch (e:Exception) {
                Log.d("Exception", "message : " + e.message)
                Toast.makeText(this, "Ingresa el operando", Toast.LENGTH_SHORT).show()
            }

        }

    }




}

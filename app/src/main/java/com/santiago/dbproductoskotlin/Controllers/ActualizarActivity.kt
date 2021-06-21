package com.santiago.dbproductoskotlin.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.santiago.dbproductoskotlin.Models.DBManager
import com.santiago.dbproductoskotlin.Models.Producto
import com.santiago.dbproductoskotlin.R
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {
    var dbManager = DBManager(this)
    var id = ""
    var marca = ""
    var nombre = ""
    var cantidad = ""
    var precio = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)



        pasoParametros()
        actualizar()
        eliminar()
    }

    private fun pasoParametros() {
        var bundle = intent.extras
        id = bundle?.get("id").toString()
        marca = bundle?.get("marca").toString()
        nombre = bundle?.get("nombre").toString()
        cantidad = bundle?.get("cantidad").toString()
        precio = bundle?.get("precio").toString()

        editTextMarcaActualizar.setText(marca.toString())
        editTextNombreActualizar.setText(nombre.toString())
        editTextCantidadActualizar.setText(cantidad.toString())
        editTextPrecioActualizar.setText(precio.toString())
    }
    private fun actualizar() {
        buttonActualizar.setOnClickListener {
            dbManager.actualizar(Producto(id.toInt(),
                editTextMarcaActualizar.text.toString(),
                editTextNombreActualizar.text.toString(),
                editTextCantidadActualizar.text.toString(),
                editTextPrecioActualizar.text.toString()))
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun eliminar() {
        buttonEliminar.setOnClickListener {
            dbManager.eliminar(Producto(id.toInt(),"","","",""))
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
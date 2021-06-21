package com.santiago.dbproductoskotlin.Controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.santiago.dbproductoskotlin.Models.DBManager
import com.santiago.dbproductoskotlin.Models.Producto
import com.santiago.dbproductoskotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dbManager = DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var dbHelper =  DBHelper(this)
//        dbHelper.writableDatabase

        insertar()
        listar()
    }

    private fun listar() {
        var arrayAdapter = ArrayAdapter<Producto>(this,android.R.layout.simple_list_item_1,dbManager.listar())
        listViewListarProductos.adapter = arrayAdapter
        listViewListarProductos.setOnItemClickListener { parent, view, position, id ->
            var pedazos =  parent.getItemAtPosition(position).toString()
            var arrayList = pedazos.split(" ")
            var intent = Intent(this,ActualizarActivity::class.java)
                intent.putExtra("id",arrayList.get(0)).toString()
                intent.putExtra("marca",arrayList.get(1)).toString()
                intent.putExtra("nombre",arrayList.get(2)).toString()
                intent.putExtra("cantidad",arrayList.get(3)).toString()
                intent.putExtra("precio",arrayList.get(4)).toString()
            startActivity(intent)
        }
    }

    private fun insertar() {
        buttonInsertarProducto.setOnClickListener {
            var result = dbManager.insertar(Producto(editTextMarcaProducto.text.toString(),editTextNombreProducto.text.toString(),editTextCantidadProducto.text.toString(),editTextPrecioProducto.text.toString()))
            if(result>0){
                Toast.makeText(this, "SE INSERTO", Toast.LENGTH_SHORT).show()
                listar()
            }else{
                Toast.makeText(this, "NOE SE INSERTO", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
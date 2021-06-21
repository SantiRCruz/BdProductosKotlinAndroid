package com.santiago.dbproductoskotlin.Models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager (context:Context) {
    var dbHelper =  DBHelper(context)
    var db : SQLiteDatabase ?= null

    fun openDBWr(){
        db =  dbHelper.writableDatabase
    }

    fun openDBRd(){
        db =  dbHelper.readableDatabase
    }
    fun closeDB(){
        if (db!=null){
            db?.close()
        }
    }
    fun insertar (producto : Producto):Long{
        openDBWr()
        var values = ContentValues()
        values.put(Constantes.TABLE_COLUMN_2,producto.marca)
        values.put(Constantes.TABLE_COLUMN_3,producto.nombre)
        values.put(Constantes.TABLE_COLUMN_4,producto.cantidad)
        values.put(Constantes.TABLE_COLUMN_5,producto.precio)
        var result = db?.insert(Constantes.TABLE_NAME,null,values)
        closeDB()
        return result!!
    }
    fun listar():MutableList<Producto>{
        var lista :MutableList<Producto> = ArrayList<Producto>()
        openDBRd()
        var result = db?.rawQuery(Constantes.CONSULTA,null)
        if (result!!.moveToFirst())
            do {
                var producto = Producto()
                producto.id =  result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_1)).toInt()
                producto.marca =  result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_2))
                producto.nombre =  result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_3))
                producto.cantidad =  result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_4))
                producto.precio =  result!!.getString(result.getColumnIndex(Constantes.TABLE_COLUMN_5))
                lista.add(producto)
            }while (result.moveToNext())
        closeDB()
        return lista
    }
    fun actualizar(producto: Producto):Int{
        openDBWr()
        var values = ContentValues()
        values.put(Constantes.TABLE_COLUMN_2,producto.marca)
        values.put(Constantes.TABLE_COLUMN_3,producto.nombre)
        values.put(Constantes.TABLE_COLUMN_4,producto.cantidad)
        values.put(Constantes.TABLE_COLUMN_5,producto.precio)
        var result =  db?.update(Constantes.TABLE_NAME,values," ID =?", arrayOf(producto.id.toString()))
        closeDB()
        return result!!
    }
    fun eliminar(producto: Producto){
        openDBWr()
        db?.delete(Constantes.TABLE_NAME,"ID=?", arrayOf(producto.id.toString()))
        closeDB()
    }
}
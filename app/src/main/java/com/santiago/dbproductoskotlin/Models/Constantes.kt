package com.santiago.dbproductoskotlin.Models

class Constantes {
    companion object{
        val BD_NAME = "PRODUCTOS"
        val BD_VERSION = 1

        val TABLE_NAME = "producto"
        val TABLE_COLUMN_1 = "ID"
        val TABLE_COLUMN_2 = "marca"
        val TABLE_COLUMN_3 = "nombre"
        val TABLE_COLUMN_4 = "cantidad"
        val TABLE_COLUMN_5 = "precio"


        val TABLE_CREATE = " CREATE TABLE " + TABLE_NAME + " ( " +
                TABLE_COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TABLE_COLUMN_2 + " TEXT NOT NULL , " +
                TABLE_COLUMN_3 + " TEXT NOT NULL , " +
                TABLE_COLUMN_4 + " TEXT NOT NULL , " +
                TABLE_COLUMN_5 + " TEXT NOT NULL ) "

        val CONSULTA = " SELECT * FROM " + TABLE_NAME
    }
}
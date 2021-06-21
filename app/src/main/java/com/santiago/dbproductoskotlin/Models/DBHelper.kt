package com.santiago.dbproductoskotlin.Models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context, Constantes.BD_NAME, null, Constantes.BD_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constantes.TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
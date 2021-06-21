package com.santiago.dbproductoskotlin.Models

class Producto {
    var id = 0
    var marca = ""
    var nombre = ""
    var cantidad = ""
    var precio = ""

    constructor(marca: String, nombre: String, cantidad: String, precio: String) {
        this.marca = marca
        this.nombre = nombre
        this.cantidad = cantidad
        this.precio = precio
    }

    constructor()

    constructor(id: Int, marca: String, nombre: String, cantidad: String, precio: String) {
        this.id = id
        this.marca = marca
        this.nombre = nombre
        this.cantidad = cantidad
        this.precio = precio
    }

    override fun toString(): String {
        return "$id $marca $nombre $cantidad $precio"
    }

}
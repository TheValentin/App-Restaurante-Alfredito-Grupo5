package com.example.restaurante_alfredito.utilidades;

public interface GlobalesApp {
    String BDD="restaurante.db";
    String TBL_CLIENTE="clientes ";
    String DDL_TBL_CLIENTE="CREATE TABLE "+TBL_CLIENTE+" (\n" +
            "    idclientes INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                              NOT NULL\n" +
            "                              UNIQUE,\n" +
            "    nombre     VARCHAR (50),\n" +
            "    apellido   VARCHAR (50),\n" +
            "    dni        CHAR (8)       UNIQUE,\n" +
            "    telefono   VARCHAR (9),\n" +
            "    correo     VARCHAR (50)   UNIQUE,\n" +
            "    direccion  VARCHAR (50),\n" +
            "    usuario    VARCHAR (50)   UNIQUE,\n" +
            "    contrasena VARCHAR (8000) \n" +
            ");";
    String TBL_ADMIN="admin";
    String DDL_TBL_ADMIN="CREATE TABLE "+TBL_ADMIN+" (\n" +
            "    idadmin    INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
            "                              UNIQUE,\n" +
            "    nombre     VARCHAR (50),\n" +
            "    apellido   VARCHAR (50),\n" +
            "    dni        CHAR (8)       UNIQUE,\n" +
            "    telefono   VARCHAR (9),\n" +
            "    foto       BLOB,\n" +
            "    usuario    VARCHAR (50)   UNIQUE,\n" +
            "    contrasema VARCHAR (8000) \n" +
            ");";
    String TBL_MOTORIZADO="motorizado ";
    String DDL_TBL_MOTORIZADO="CREATE TABLE "+TBL_MOTORIZADO+" (\n" +
            "    idmotorizado INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                                UNIQUE,\n" +
            "    nombre       VARCHAR (50),\n" +
            "    apellido     VARCHAR (50),\n" +
            "    dni          CHAR (8)       UNIQUE,\n" +
            "    telefono     VARCHAR (9),\n" +
            "    foto         BLOB,\n" +
            "    usuario      VARCHAR (50)   UNIQUE,\n" +
            "    contrasena   VARCHAR (8000) \n" +
            ");";
    String TBL_PRODUCTO="producto ";
    String DDL_TBL_PRODUCTO="CREATE TABLE "+TBL_PRODUCTO+" (\n" +
            "    idproducto INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                              UNIQUE,\n" +
            "    nombre     VARCHAR (50)   UNIQUE,\n" +
            "    stock      INT,\n" +
            "    categoria  VARCHAR (50),\n" +
            "    precio     DECIMAL (8, 2),\n" +
            "    imagen     BLOB\n" +
            ");";
    String TBL_PEDIDO="pedido";
    String DDL_TBL_PEDIDO="CREATE TABLE "+TBL_PEDIDO+" (\n" +
            "    idpedido     INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                                UNIQUE,\n" +
            "    fecha        DATE,\n" +
            "    estado       VARCHAR (50),\n" +
            "    total        DECIMAL (8, 2),\n" +
            "    fkclientes   CHAR (5)       REFERENCES clientes (idclientes),\n" +
            "    fkmotorizado CHAR (5)       REFERENCES motorizado (idmotorizado) \n" +
            ");\n";
    String TBL_DETALLE_PEDIDO="detalle_pedido ";
    String DDL_TBL_DETALLE_PEDIDO="CREATE TABLE "+TBL_DETALLE_PEDIDO+" (\n" +
            "    iddetalle_pedido INTEGER  PRIMARY KEY AUTOINCREMENT\n" +
            "                              UNIQUE,\n" +
            "    fkpedido         CHAR (5) REFERENCES pedido (idpedido) \n" +
            "                              NOT NULL,\n" +
            "    fkproducto       CHAR (5) REFERENCES producto (idproducto) \n" +
            "                              NOT NULL,\n" +
            "    cantidad         INT      NOT NULL\n" +
            ");";
    int VERSION=1;
}

package com.example.restaurante_alfredito.utilidades;

public interface GlobalesApp {
    String BDD="restaurante.db";

    String TBL_MOTORIZADO="motorizado";
    String TBL_ADMINISTRADOR="admin";
    String TBL_CLIENTES="clientes";
    String TBL_PRODUCTO="producto";
    String TBL_PEDIDO="pedido";
    String TBL_DETALLE_PEDIDO="detalle_pedido";
    int VERSION=1;

    String DDL_TABLA_MOTORIZADO ="CREATE TABLE motorizado (\n" +
            "    idmotorizado CHAR (5)       PRIMARY KEY\n" +
            "                                ,\n" +
            "    nombre       VARCHAR (50),\n" +
            "    apellido     VARCHAR (50),\n" +
            "    dni          CHAR (8)       UNIQUE,\n" +
            "    telefono     VARCHAR (9),\n" +
            "    foto         BLOB,\n" +
            "    usuario      VARCHAR (50)   UNIQUE,\n" +
            "    contrasena   VARCHAR (8000) \n" +
            ");";

    String DDL_TABLA_ADMINISTRADOR ="CREATE TABLE admin (\n" +
            "    idadmin    CHAR (5)       PRIMARY KEY\n" +
            "                             ,\n" +
            "    nombre     VARCHAR (50),\n" +
            "    apellido   VARCHAR (50),\n" +
            "    dni        CHAR (8)       ,\n" +
            "    telefono   VARCHAR (9),\n" +
            "    foto       BLOB,\n" +
            "    usuario    VARCHAR (50)   ,\n" +
            "    contrasena VARCHAR (8000) \n" +
            ");";

    String DDL_TABLA_CLIENTES ="CREATE TABLE clientes (\n" +
            "    idclientes CHAR (5)       PRIMARY KEY\n" +
            "                              NOT NULL,\n" +
            "    nombre     VARCHAR (50),\n" +
            "    apellido   VARCHAR (50),\n" +
            "    dni        CHAR (8)       UNIQUE,\n" +
            "    telefono   VARCHAR (9),\n" +
            "    correo     VARCHAR (50)   UNIQUE,\n" +
            "    direccion  VARCHAR (50),\n" +
            "    usuario    VARCHAR (50)   UNIQUE,\n" +
            "    contrasena VARCHAR (8000) \n" +
            ");";

    String DDL_TABLA_PRODUCTO ="CREATE TABLE producto (\n" +
            "    idproducto CHAR (5)       PRIMARY KEY\n" +
            "                              ,\n" +
            "    nombre     VARCHAR (50)   UNIQUE,\n" +
            "    stock      INT,\n" +
            "    categoria  VARCHAR (50),\n" +
            "    precio     DECIMAL (8, 2),\n" +
            "    imagen     BLOB\n" +
            ");\n";

    String DDL_TABLA_PEDIDO="CREATE TABLE pedido (\n" +
            "    idpedido     CHAR (5)       PRIMARY KEY,\n" +
            "    fecha        DATE,\n" +
            "    estado       VARCHAR (50),\n" +
            "    total        DECIMAL (8, 2),\n" +
            "    fkclientes   CHAR (5)       REFERENCES clientes (idclientes),\n" +
            "    fkmotorizado CHAR (5)       REFERENCES motorizado (idmotorizado) \n" +
            ");";

    String DDL_TABLA_DETALLE_PEDIDO="CREATE TABLE detalle_pedido (\n" +
            "    iddetalle_pedido INTEGER  PRIMARY KEY AUTOINCREMENT\n" +
            "                              NOT NULL,\n" +
            "    fkpedido         CHAR (5) REFERENCES pedido (idpedido) \n" +
            "                              NOT NULL,\n" +
            "    fkproducto       CHAR (5) NOT NULL\n" +
            "                              REFERENCES producto (idproducto),\n" +
            "    cantidad         INT      NOT NULL\n" +
            ");\n";

}

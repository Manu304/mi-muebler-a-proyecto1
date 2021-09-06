/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrojas.pruebas.mi_muebleria.services;

import java.util.*;

/**
 *
 * @author Manu
 */
public interface EntityService<T> {

    /**
     * Metodo que llama al repository de la entidad para listar los elementos de una
     * tabla en la base de datos
     * 
     * @return Retorna una lista con los elementos de la tabla en la base de datos
     */
    List<T> listar();

    /**
     * Metodo para obtener un elemento específico de la base de datos, llamando al
     * repository de la entidad
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos,
     *                   del tipo string
     * @return Retorna el elemento encontrado en la tabla como un optional
     * @throws SQLException
     */
    Optional<T> porIdentificador(String primaryKey);

    /**
     * Metodo para obtener un elemento específico de la base de datos, llamando al
     * repository de la entidad
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos,
     *                   del tipo entero
     * @return Retorna el elemento encontrado en la tabla como un optional
     * @throws SQLException
     */
    Optional<T> porIdentificador(Integer primaryKey);

    /**
     * Guada un elemento ya modelado dentro de la base de datos haciendo uso del
     * repository de la entidad
     * 
     * @param t Elemento ya mapeado para ingresar a la tabla de la base de datos
     * @throws SQLException
     */
    void guardar(T t);

    /**
     * Metodo para eliminar un elemento de la base de datos, haciendo uso del
     * repository de la entidad
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo String
     * @throws SQLException
     */

    void eliminar(String primaryKey);

    /**
     * Metodo para eliminar un elemento de la base de datos, haciendo uso del
     * repository de la entidad
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo entero
     * @throws SQLException
     */

    void eliminar(Integer primaryKey);

    /**
     * Método para ordenar obtener los elementos de la tabla en la base de datos
     * haciendo uso del repository de la entidad
     * 
     * @param columna identificador de la columna en la base de datos
     * @param asc     Indicar si se desea ordenar de manera ascendente o descendente
     * @return Retorna una lista con todos los elementos ordenados
     * @throws SQLException
     */

    List<T> orderBy(int columna, boolean asc);

}

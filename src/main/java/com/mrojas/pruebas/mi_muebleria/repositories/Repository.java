package com.mrojas.pruebas.mi_muebleria.repositories;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Manu
 */
public interface Repository<T> {

    /**
     * Metodo para listar los elementos de una tabla de la base de datos
     * 
     * @return Retorna una lista de los elementos de la tabla ya modeladas
     * @throws SQLException
     */
    List<T> listar() throws SQLException;

    /**
     * Metodo para obtener un elemento específico de la base de datos
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo string
     * @return Retorna el elemento encontrado en la tabla como un optional
     * @throws SQLException
     */

    T porIdentificador(String primaryKey) throws SQLException;

    /**
     * Metodo para obtener un elemento específico de la base de datos
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo entero
     * @return Retorna el elemento encontrado en la tabla como un optional
     * @throws SQLException
     */
    T porIdentificador(Integer primaryKey) throws SQLException;

    /**
     * Guada un elemento ya modelado dentro de la base de datos
     * 
     * @param t Elemento ya mapeado para ingresar a la tabla de la base de datos
     * @throws SQLException
     */
    void guardar(T t) throws SQLException;

    /**
     * Metodo para eliminar un elemento de la base de datos
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo String
     * @throws SQLException
     */

    void eliminar(String primaryKey) throws SQLException;

    /**
     * Metodo para eliminar un elemento de la base de datos
     * 
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     *                   del tipo entero
     * @throws SQLException
     */

    void eliminar(Integer primaryKey) throws SQLException;

    /**
     * Método para ordenar obtener los elementos de la tabla en la base de datos
     * 
     * @param columna El nombre del atributo de la tabla a ordenar
     * @param asc     Indicar si se desea ordenar de manera ascendente o descendente
     * @return Retorna una lista con todos los elementos ordenados
     * @throws SQLException
     */

    List<T> orderBy(String columna, boolean asc) throws SQLException;
}
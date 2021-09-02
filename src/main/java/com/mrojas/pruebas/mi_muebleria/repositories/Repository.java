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
     * @return Retorna una lista de los elementos de la tabla ya modeladas
     * @throws SQLException
     */
    List<T> listar() throws SQLException;

    /**
     * Metodo para obtener un elemento específico de la base de datos
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     * @return Retorna el elemento encontrado en la tabla como un optional
     * @throws SQLException
     */

    T porIdentificador(String primaryKey) throws SQLException;
    
    T porIdentificador(Integer primaryKey) throws SQLException;
    /**
     * Guada un elemento ya modelado dentro de la base de datos
     * @param t Elemento ya mapeado para ingresar a la tabla de la base de datos
     * @throws SQLException
     */
    void guardar(T t) throws SQLException;

    /**
     * Metodo para eliminar un elemento de la base de datos
     * @param primaryKey Valor único que identifica el elemento en la base de datos
     * @throws SQLException
     */

    void eliminar(String primaryKey) throws SQLException;
    
    void eliminar(Integer primaryKey) throws SQLException;
}
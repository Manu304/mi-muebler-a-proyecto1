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
public interface EntityService <T> {
    
    List<T> listar();
    
    
    Optional<T> porIdentificador(String primaryKey);
    
    Optional<T> porIdentificador(Integer primaryKey);
    
    void guardar (T t);
    
    void eliminar(String primaryKey);
    
    void eliminar(Integer primaryKey);
    
    
    
    
    
    
}

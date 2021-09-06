package com.mrojas.pruebas.mi_muebleria.services.pieza;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mrojas.pruebas.mi_muebleria.models.Pieza;
import com.mrojas.pruebas.mi_muebleria.repositories.pieza.PiezaRepository;
import com.mrojas.pruebas.mi_muebleria.services.EntityService;
import com.mrojas.pruebas.mi_muebleria.services.ServiceJdbcException;

public class PiezaService implements EntityService<Pieza> {

    public static final int COL_TIPO = 0;
    public static final int COL_COSTO = 1;
    public static final int COL_CANTIDAD = 2;
    public static final int COL_ID = 3;

    private PiezaRepository piezaRepository;
    private static final String[] COLUMNAS = { "tipo", "costo", "cantidad", "id" };

    public PiezaService() {
        this.piezaRepository = new PiezaRepository();
    }

    @Override
    public List<Pieza> listar() {
        try {
            return piezaRepository.listar();
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Pieza> porIdentificador(String primaryKey) {
        try {
            return Optional.ofNullable(piezaRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Pieza> porIdentificador(Integer primaryKey) {
        try {
            return Optional.ofNullable(piezaRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void guardar(Pieza t) {
        try {
            piezaRepository.guardar(t);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(String primaryKey) {

    }

    @Override
    public void eliminar(Integer primaryKey) {
        try {
            piezaRepository.eliminar(primaryKey);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Pieza> orderBy(int columna, boolean asc) {
        System.out.println("estoy por ordenar");
        int col = columna < COLUMNAS.length ? columna : 0;
        
        try {
            return piezaRepository.orderBy(COLUMNAS[col], asc);
        } catch (ArrayIndexOutOfBoundsException | SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

}

package com.mrojas.pruebas.mi_muebleria.services.pieza;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mrojas.pruebas.mi_muebleria.models.Pieza;
import com.mrojas.pruebas.mi_muebleria.repositories.pieza.PiezaRepository;
import com.mrojas.pruebas.mi_muebleria.services.EntityService;
import com.mrojas.pruebas.mi_muebleria.services.ServiceJdbcException;

public class PiezaService implements EntityService<Pieza> {

    private PiezaRepository piezaRepository;

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

}

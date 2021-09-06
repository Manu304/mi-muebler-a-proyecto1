package com.mrojas.pruebas.mi_muebleria.services.mueble;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mrojas.pruebas.mi_muebleria.models.Mueble;
import com.mrojas.pruebas.mi_muebleria.repositories.mueble.MuebleRepository;
import com.mrojas.pruebas.mi_muebleria.services.EntityService;
import com.mrojas.pruebas.mi_muebleria.services.ServiceJdbcException;

public class MuebleService implements EntityService<Mueble> {

    private MuebleRepository muebleRepository;

    public MuebleService(){
        this.muebleRepository = new MuebleRepository();
    }

    @Override
    public List<Mueble> listar() {
        try {
            return muebleRepository.listar();
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Mueble> porIdentificador(String primaryKey) {
        try {
            return Optional.ofNullable(muebleRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Mueble> porIdentificador(Integer primaryKey) {
        try {
            return Optional.ofNullable(muebleRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void guardar(Mueble t) {
        try {
            muebleRepository.guardar(t);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(String primaryKey) {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminar(Integer primaryKey) {
        try {
            muebleRepository.eliminar(primaryKey);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public List<Mueble> orderBy(int columna, boolean asc) {
        return null;
    }

}

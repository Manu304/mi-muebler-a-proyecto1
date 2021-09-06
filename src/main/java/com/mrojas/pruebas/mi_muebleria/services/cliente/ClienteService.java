package com.mrojas.pruebas.mi_muebleria.services.cliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mrojas.pruebas.mi_muebleria.models.Cliente;
import com.mrojas.pruebas.mi_muebleria.repositories.cliente.ClienteRepository;
import com.mrojas.pruebas.mi_muebleria.services.EntityService;
import com.mrojas.pruebas.mi_muebleria.services.ServiceJdbcException;

public class ClienteService implements EntityService<Cliente> {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    @Override
    public List<Cliente> listar() {
        try {
            return clienteRepository.listar();
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Cliente> porIdentificador(String primaryKey) {
        try {
            return Optional.ofNullable(clienteRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
        
    }

    @Override
    public Optional<Cliente> porIdentificador(Integer primaryKey) {
        try {
            return Optional.ofNullable(clienteRepository.porIdentificador(primaryKey));
        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void guardar(Cliente t) {
        try {
            clienteRepository.guardar(t);
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
            clienteRepository.eliminar(primaryKey);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public List<Cliente> orderBy(int columna, boolean asc) {
        // TODO Auto-generated method stub
        return null;
    }

}

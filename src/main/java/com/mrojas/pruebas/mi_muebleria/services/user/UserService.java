package com.mrojas.pruebas.mi_muebleria.services.user;

import com.mrojas.pruebas.mi_muebleria.models.users.Usuario;
import com.mrojas.pruebas.mi_muebleria.repositories.users.UserRepository;
import com.mrojas.pruebas.mi_muebleria.services.EntityService;
import com.mrojas.pruebas.mi_muebleria.services.ServiceJdbcException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Manu
 */
public class UserService implements EntityService<Usuario> {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public Optional<Usuario> login(String nombre, String password) {
        try {
            return Optional.ofNullable(userRepository.verificarCredenciales(nombre, password));

        } catch (SQLException ex) {
            throw new ServiceJdbcException(ex.getMessage(), ex.getCause());
        }

    }

    @Override
    public List<Usuario> listar() {
        try {
            return userRepository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> porIdentificador(String primaryKey) {
        try {
            return Optional.ofNullable(userRepository.porIdentificador(primaryKey));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> porIdentificador(Integer primaryKey) {
        return Optional.empty();
    }

    @Override
    public void guardar(Usuario t) {
        try {
            userRepository.guardar(t);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(String primaryKey) {
        try {
            userRepository.eliminar(primaryKey);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void eliminar(Integer primaryKey) {

    }

    @Override
    public List<Usuario> orderBy(int columna, boolean asc) {
        return null;

    }
}
package com.mrojas.pruebas.mi_muebleria.repositories.users;

import com.mrojas.pruebas.mi_muebleria.models.users.Usuario;
import com.mrojas.pruebas.mi_muebleria.repositories.Repository;
import com.mrojas.pruebas.mi_muebleria.util.ConexionBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manu
 */
public class UserRepository implements Repository<Usuario> {

    private static final String TABLA = "usuario";

    public UserRepository() {

    }

    /**
     * Metodo para verificar las credenciales del usuario en la base de datos.
     * @param nombre El nombre del usuario en la base de datos, osea el identificador.
     * @param password La contraseña del usuario en la base de datos.
     * @return Retorna un objeto usuario si encuentra alguna coincidencia, de lo contrario retorna null.
     * @throws SQLException
     */
    public Usuario verificarCredenciales(String nombre, String password) throws SQLException {
        Usuario user = null;
        String sql = "SELECT * FROM " + TABLA + " WHERE nombre = ? AND password = ?";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = getUsuario(rs);
                }
            }
        }
        return user;
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA)) {
            while (rs.next()) {
                Usuario user = getUsuario(rs);
                usuarios.add(user);
            }
        }
        return usuarios;
    }

    @Override
    public Usuario porIdentificador(String primaryKey) throws SQLException {
        Usuario user = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE nombre = ?")) {
            stmt.setString(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = getUsuario(rs);
                }
            }

        }
        return user;
    }

    @Override
    public Usuario porIdentificador(Integer intgr) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuario t) throws SQLException {
        String sql;
        boolean existe = t.getNombre() != null && porIdentificador(t.getNombre()) != null;
        if (existe) {
            sql = "UPDATE " + TABLA + " SET password = ?, tipo = ?, activo = ? WHERE nombre = ?";
        } else {
            sql = "INSERT INTO " + TABLA + " (password, tipo, activo, nombre) VALUES (?, ?, ?, ?)";
        }

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, t.getPassword());
            stmt.setInt(2, t.getTipo());
            stmt.setBoolean(3, t.isActivo());
            stmt.setString(4, t.getNombre());

            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(String primaryKey) throws SQLException {
        String sql = "DELETE FROM " + TABLA + " WHERE nombre = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, primaryKey);
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Integer primaryKey) throws SQLException {

    }

    @Override
    public List<Usuario> orderBy(String columna, boolean asc) throws SQLException {
        return null;
    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    private Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setNombre(rs.getString("nombre"));
        user.setPassword(rs.getString("password"));
        user.setTipo(rs.getInt("tipo"));
        user.setActivo(rs.getBoolean("activo"));
        System.out.println("el usuario get usuario es: " + rs.getBoolean("activo"));

        return user;
    }

}

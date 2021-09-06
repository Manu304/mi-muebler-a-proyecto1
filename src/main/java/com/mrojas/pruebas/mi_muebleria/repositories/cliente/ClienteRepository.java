package com.mrojas.pruebas.mi_muebleria.repositories.cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mrojas.pruebas.mi_muebleria.models.Cliente;
import com.mrojas.pruebas.mi_muebleria.repositories.Repository;
import com.mrojas.pruebas.mi_muebleria.util.ConexionBaseDatos;

public class ClienteRepository implements Repository<Cliente> {

    private static final String TABLA = "cliente";

    @Override
    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA)) {
            while (rs.next()) {
                Cliente cliente = getCliente(rs);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    @Override
    public Cliente porIdentificador(String primaryKey) throws SQLException {
        Cliente cliente = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE nit = ?")) {
            stmt.setString(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = getCliente(rs);
                }
            }

        }
        return cliente;
    }

    @Override
    public Cliente porIdentificador(Integer primaryKey) throws SQLException {
        Cliente cliente = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE id = ?")) {
            stmt.setInt(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = getCliente(rs);
                }
            }

        }
        return cliente;
    }

    @Override
    public void guardar(Cliente t) throws SQLException {
        String sql;
        boolean existe = t.getNit() != null && porIdentificador(t.getNit()) != null;
        if (existe) {
            sql = "UPDATE " + TABLA + " SET nombre = ?, direccion = ?, municipio = ?, departamento = ? WHERE nit = ?";
        } else {
            sql = "INSERT INTO " + TABLA + " (nombre, direccion, municipio, departamento) VALUES (?, ?, ?, ?)";
        }

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, t.getNombre());
            stmt.setString(2, t.getDireccion());
            stmt.setString(3, t.getMunicipio());
            stmt.setString(4, t.getNit());
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(String primaryKey) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminar(Integer primaryKey) throws SQLException {
        String sql = "DELETE FROM " + TABLA + " WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, primaryKey);
            stmt.executeUpdate();
        }

    }

    @Override
    public List<Cliente> orderBy(String columna, boolean asc) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    private Cliente getCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNit(rs.getString("nit"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setDireccion(rs.getString("direccion"));
        if (rs.getString("municipio") != null) {
            cliente.setMunicipio(rs.getString("municipio"));
            cliente.setDepartamento(rs.getString("departamento"));
        }
        return cliente;
    }

}

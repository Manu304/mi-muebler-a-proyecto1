package com.mrojas.pruebas.mi_muebleria.repositories.pieza;

import java.sql.*;
import java.util.*;
import com.mrojas.pruebas.mi_muebleria.models.Pieza;
import com.mrojas.pruebas.mi_muebleria.repositories.Repository;
import com.mrojas.pruebas.mi_muebleria.util.ConexionBaseDatos;

public class PiezaRepository implements Repository<Pieza> {

    private static final String TABLA = "pieza";

    @Override
    public List<Pieza> listar() throws SQLException {
        List<Pieza> piezas = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA)) {
            while (rs.next()) {
                Pieza pieza = getPieza(rs);
                piezas.add(pieza);
            }
        }
        return piezas;
    }

    @Override
    public Pieza porIdentificador(String primaryKey) throws SQLException {
        Pieza pieza = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE tipo = ?")) {
            stmt.setString(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pieza = getPieza(rs);
                }
            }

        }
        return pieza;
    }

    @Override
    public Pieza porIdentificador(Integer primaryKey) throws SQLException {
        Pieza pieza = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE id = ?")) {
            stmt.setInt(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pieza = getPieza(rs);
                }
            }

        }
        return pieza;
    }

    @Override
    public void guardar(Pieza t) throws SQLException {
        String sql;
        boolean existe = t.getId() != null && porIdentificador(t.getId()) != null;
        if (existe) {
            sql = "UPDATE " + TABLA + " SET costo = ?, cantidad = ?, tipo = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO " + TABLA + " (costo, cantidad, tipo) VALUES (?, ?, ?)";
        }

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, t.getCosto());
            stmt.setInt(2, t.getCantidad());
            stmt.setString(3, t.getTipo());
            if (existe) {
                stmt.setInt(4, t.getId());
            }

            stmt.executeUpdate();
        }

    }

    @Override
    public List<Pieza> orderBy(String columna, boolean asc) throws SQLException {
        List<Pieza> piezas = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt
                        .executeQuery("SELECT * FROM " + TABLA + " ORDER BY " + columna + (asc ? " ASC" : " DESC"))) {
            while (rs.next()) {
                Pieza pieza = getPieza(rs);
                piezas.add(pieza);
            }
        }
        return piezas;
    }

    @Override
    public void eliminar(String primaryKey) throws SQLException {

    }

    @Override
    public void eliminar(Integer primaryKey) throws SQLException {
        String sql = "DELETE FROM " + TABLA + " WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, primaryKey);
            stmt.executeUpdate();
        }

    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    private Pieza getPieza(ResultSet rs) throws SQLException {
        Pieza pieza = new Pieza();
        pieza.setId(rs.getInt("id"));
        pieza.setTipo(rs.getString("tipo"));
        pieza.setCosto(rs.getDouble("costo"));
        pieza.setCantidad(rs.getInt("cantidad"));
        return pieza;
    }

}

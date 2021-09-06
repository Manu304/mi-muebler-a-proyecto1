package com.mrojas.pruebas.mi_muebleria.repositories.mueble;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mrojas.pruebas.mi_muebleria.models.Mueble;
import com.mrojas.pruebas.mi_muebleria.repositories.Repository;
import com.mrojas.pruebas.mi_muebleria.util.ConexionBaseDatos;

public class MuebleRepository implements Repository<Mueble> {
    private static final String TABLA = "mueble";

    @Override
    public List<Mueble> listar() throws SQLException {
        List<Mueble> muebles = new ArrayList<>();
        try (Connection connection = getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLA)) {
            while (rs.next()) {
                Mueble mueble = getMueble(rs);
                muebles.add(mueble);
            }
        }
        return muebles;

    }

    @Override
    public Mueble porIdentificador(String primaryKey) throws SQLException {
        Mueble mueble = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE nombre = ?")) {
            stmt.setString(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    mueble = getMueble(rs);
                }
            }

        }
        return mueble;
    }

    @Override
    public Mueble porIdentificador(Integer primaryKey) throws SQLException {
        Mueble mueble = null;
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + TABLA + " WHERE id = ?")) {
            stmt.setInt(1, primaryKey);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    mueble = getMueble(rs);
                }
            }

        }
        return mueble;
    }

    @Override
    public void guardar(Mueble t) throws SQLException {
        String sql;
        boolean existe = t.getNombre() != null && porIdentificador(t.getNombre()) != null;
        if (existe) {
            sql = "UPDATE " + TABLA + " SET precio = ?, nombre WHERE id = ?";
        } else {
            sql = "INSERT INTO " + TABLA + " (precio, nombre) VALUES (?, ?)";
        }

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, t.getPrecio());
            stmt.setString(2, t.getNombre());
            if (existe) {
                stmt.setInt(3, t.getId());
            }

            stmt.executeUpdate();
        }

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

    @Override
    public List<Mueble> orderBy(String columna, boolean asc) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getConnection();
    }

    private Mueble getMueble(ResultSet rs) throws SQLException {
        Mueble mueble = new Mueble();
        mueble.setId(rs.getInt("id"));
        mueble.setNombre(rs.getString("nombre"));
        mueble.setPrecio(rs.getDouble("precio"));
        return mueble;

    }

}

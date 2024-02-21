/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datasystem.dao;

import com.datasystem.modelos.Cliente;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author bm_vd
 */
public class ClienteDAO {

    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Cliente cliente) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setInt(1, 0);
                statement.setString(2, cliente.getNombre_cliente());
                statement.setString(3, cliente.getEmail());
                statement.setString(4, cliente.getTelefono());
                statement.setString(5, cliente.getDireccion());
                statement.setString(6, cliente.getUltima_modificacion());
                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        cliente.setId_cliente(resultSet.getInt(1));

                        System.out.println(String.format("Fue insertado el clinete: %s", cliente));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            var querySelect = "select id_cliente, nombre_cliente, email_cliente, tel_cliente, ultima_modificacion from clientes";
            final PreparedStatement statement = con.prepareStatement(querySelect);

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        clientes.add(new Cliente(
                                resultSet.getInt("id_cliente"),
                                resultSet.getString("nombre_cliente"),
                                resultSet.getString("email_cliente"),
                                resultSet.getString("tel_cliente"),
                                resultSet.getString("ultima_modificacion")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }

    public Cliente encontrarClientePorId(int idCliente) {
        try {
                final String query = "SELECT id_cliente, nombre_cliente, email_cliente, tel_cliente, dir_cliente, ultima_modificacion FROM clientes WHERE id_cliente =?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setInt(1, idCliente);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return new Cliente(
                                rs.getInt("id_cliente"),
                                rs.getString("nombre_cliente"),
                                rs.getString("email_cliente"),
                                rs.getString("tel_cliente"),
                                rs.getString("dir_cliente"),
                                rs.getString("ultima_modificacion"));
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            // Log or handle the exception appropriately
            throw new RuntimeException("Error retrieving user with id: " + idCliente, e);
        }
    }
}

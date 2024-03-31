/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datasystem.dao;

import com.datasystem.modelos.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bm_vd
 */
public class EquipoDAO {

    private Connection con;

    public EquipoDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Equipo equipo) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setInt(1, 0);
                statement.setInt(2, equipo.getId_cliente());
                statement.setString(3, equipo.getTipo_equipo());
                statement.setString(4, equipo.getMarca());
                statement.setString(5, equipo.getModelo());
                statement.setString(6, equipo.getNum_serie());
                statement.setString(7, equipo.getDia_ingreso());
                statement.setString(8, equipo.getMes_ingreso());
                statement.setString(9, equipo.getAnnio_ingreso());
                statement.setString(10, equipo.getObservaciones());
                statement.setString(11, equipo.getEstatus());
                statement.setString(12, equipo.getUltima_modificacion());
                statement.setString(13, "");
                statement.setString(14, "");
                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        equipo.setId_equipo(resultSet.getInt(1));

                        System.out.println(String.format("Fue insertado el equipo: %s", equipo));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Equipo> listar(int id_cliente) {
        List<Equipo> equipos = new ArrayList<Equipo>();
        try {
            var querySelect = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente =   ?";
            final PreparedStatement statement = con.prepareStatement(querySelect);
                 statement.setInt(1, id_cliente);
           
            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        equipos.add(new Equipo(
                                resultSet.getInt("id_equipo"),
                                resultSet.getString("tipo_equipo"),
                                resultSet.getString("marca"),
                                resultSet.getString("estatus")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipos;
    }

}

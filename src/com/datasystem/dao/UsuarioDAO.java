/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datasystem.dao;

import java.sql.*;

import com.datasystem.modelos.Usuario;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author bm_vd
 */
public class UsuarioDAO {

    private Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Usuario usuario) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setInt(1, 0);
                statement.setString(2, usuario.getNombre_usuario());
                statement.setString(3, usuario.getEmail());
                statement.setString(4, usuario.getTelefono());
                statement.setString(5, usuario.getUsername());
                statement.setString(6, usuario.getPassword());
                statement.setString(7, usuario.getTipo_nivel());
                statement.setString(8, "Activo");
                statement.setString(9, usuario.getRegistrado_por());
                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        usuario.setId_usuario(resultSet.getInt(1));

                        System.out.println(String.format("Fue insertado el producto: %s", usuario));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existeUsuarioConUsername(String username) {
        try {
            final PreparedStatement statement = con.prepareStatement("SELECT username FROM usuarios  where username = ? ");

            try (statement) {
                statement.setString(1, username);
                statement.execute();

                ResultSet rs = statement.executeQuery();
                return rs.next();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Usuario loguearse(String user, String pass) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT tipo_nivel,estatus FROM "
                    + "usuarios where username = ? and password =  ? ";
            statement = con.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getString("tipo_nivel"),
                        resultSet.getString("estatus")
                );

                return usuario;
            } else {
                return null; // Manejar el caso en el que no se encuentra un usuario con el ID dado
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario por ID", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                // No cierres la conexión aquí, ya que no la abriste en este método
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*	public List<Reserva> buscar() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {
			String sql = "SELECT id, fechaEntrada , fechaSalida, valor, formaPago FROM reservas";
			try(PreparedStatement pstm = con.prepareStatement(sql)){
				pstm.execute();
				transformarResultado(reservas, pstm );
			}
			return reservas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
     */
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            var querySelect = "SELECT id_usuario, nombre_usuario, username, tipo_nivel, estatus from usuarios";
            final PreparedStatement statement = con.prepareStatement(querySelect);

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        usuarios.add(new Usuario(resultSet.getString("nombre_usuario"), resultSet.getString("username"),
                                resultSet.getString("tipo_nivel")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }
}

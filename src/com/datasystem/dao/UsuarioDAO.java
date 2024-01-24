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

    public boolean nombreDeUsuarioNoDisponible(String username, int ID) {
        try {
            final PreparedStatement statement = con.prepareStatement("select username from usuarios where username = ? and not id_usuario = ?");

            try (statement) {
                statement.setString(1, username);
                statement.setInt(2, ID);
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
                        usuarios.add(new Usuario(
                                resultSet.getInt("id_usuario"),
                                resultSet.getString("nombre_usuario"), resultSet.getString("username"),
                                resultSet.getString("tipo_nivel")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    public Usuario obtenerUsuarioConNombredeUsuario(String username) {
        try {
            final String query = "SELECT id_usuario, nombre_usuario, email, telefono, username, password, tipo_nivel, estatus, registrado_por FROM usuarios WHERE username = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, username);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return new Usuario(
                                rs.getInt("id_usuario"),
                                rs.getString("nombre_usuario"),
                                rs.getString("email"),
                                rs.getString("telefono"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("tipo_nivel"),
                                rs.getString("estatus"),
                                rs.getString("registrado_por"));
                    } else {
                        // Handle the case when no user is found with the given username
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            // Log or handle the exception appropriately
            throw new RuntimeException("Error retrieving user with username: " + username, e);
        }
    }

    public int modificarUsuario(String nombre, String mail, String telefono, String username, String permisos_string,
            String estatus_string, int ID) {

        try {
            final PreparedStatement statement = con.prepareStatement("update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=? where id_usuario = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, mail);
                statement.setString(3, telefono);
                statement.setString(4, username);
                statement.setString(5, permisos_string);
                statement.setString(6, estatus_string);
                statement.setInt(7, ID);

                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int cambiarPassword(String password, String username) {
        try {
            final PreparedStatement statement = con.prepareStatement("update usuarios set password=? where username = ?");

            try (statement) {
                statement.setString(1, password);
                statement.setString(2, username);

                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.datasystem.controller;

/**
 *
 * @author bm_vd
 */

import com.datasystem.dao.UsuarioDAO;
import com.datasystem.factory.ConnectionFactory;
import com.datasystem.modelos.Usuario;
import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        var factory = new ConnectionFactory();
        this.usuarioDAO = new UsuarioDAO(factory.recuperaConexion());
    }

    public void guardar(Usuario usuario) {
        usuarioDAO.guardar(usuario);
    }

    public boolean existeUsuarioConUsername(String username) {
        return usuarioDAO.existeUsuarioConUsername(username);
    }

    public Usuario logearse(String user, String pass) {
        return usuarioDAO.loguearse(user, pass);
    }

    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    public Usuario obtenerUsuarioConNombredeUsuario(String username) {
        return usuarioDAO.obtenerUsuarioConNombredeUsuario(username);
    }

    public boolean nombreDeUsuarioNoDisponible(String username, int ID) {
        return usuarioDAO.nombreDeUsuarioNoDisponible(username, ID);
    }

    public int modificarUsuario(String nombre, String mail, String telefono, String username, String permisos_string, String estatus_string, int ID) {
        return usuarioDAO.modificarUsuario(nombre, mail, telefono, username, permisos_string, estatus_string, ID);
    }

    public int cambiarPassword(String password, String username) {
        return usuarioDAO.cambiarPassword(password, username);
    }

    public String obtenerNombreDeUsuarioPorUserName(String username) {
        return usuarioDAO.obtenerNombreDeUsuarioPorUserName(username);
    }

}

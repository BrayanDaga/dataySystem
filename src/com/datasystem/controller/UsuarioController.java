package com.datasystem.controller;
/**
 *
 * @author bm_vd
 */

import com.datasystem.dao.UsuarioDAO;
import com.datasystem.factory.ConnectionFactory;
import com.datasystem.modelos.Usuario;
public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        var factory = new ConnectionFactory();
        this.usuarioDAO = new UsuarioDAO(factory.recuperaConexion());
    }
    
    
    public void guardar(Usuario usuario){
        usuarioDAO.guardar(usuario);
    }
    
    public boolean existeUsuarioConUsername(String username){
       return  usuarioDAO.existeUsuarioConUsername(username);
    }
    
    public Usuario logearse(String user, String pass){
        return usuarioDAO.loguearse(user, pass);
    }
}

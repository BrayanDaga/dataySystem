package com.datasystem.controller;

import com.datasystem.dao.ClienteDAO;
import com.datasystem.modelos.Cliente;
import com.datasystem.factory.ConnectionFactory;
import java.util.List;

/**
 *
 * @author bm_vd
 */
public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        var factory = new ConnectionFactory();
        this.clienteDAO = new ClienteDAO(factory.recuperaConexion());
    }

    public void guardar(Cliente cliente) {
        clienteDAO.guardar(cliente);
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }

    public Cliente encontrarClientePorId(int IDcliente_update) {
        return clienteDAO.encontrarClientePorId(IDcliente_update);
    }
}

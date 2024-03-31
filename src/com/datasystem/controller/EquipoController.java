/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datasystem.controller;

import com.datasystem.dao.EquipoDAO;
import com.datasystem.factory.ConnectionFactory;
import com.datasystem.modelos.Equipo;
import java.util.List;

/**
 *
 * @author bm_vd
 */
public class EquipoController {


    private EquipoDAO equipoDAO;

    public EquipoController() {
        var factory = new ConnectionFactory();
        this.equipoDAO = new EquipoDAO(factory.recuperaConexion());
    }

    public void guardar(Equipo equipo) {
        equipoDAO.guardar(equipo);
    }

    public List<Equipo> listar(int id_cliente) {
        return equipoDAO.listar(id_cliente);
    }
    
}

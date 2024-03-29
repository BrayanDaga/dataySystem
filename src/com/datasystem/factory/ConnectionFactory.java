package com.datasystem.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * @author bm_vd
 */
public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() {
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/bd_ds?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("");
        pooledDataSource.setMinPoolSize(1);
        pooledDataSource.setMaxPoolSize(3);
        

        this.dataSource = pooledDataSource;
    }

    public Connection recuperaConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

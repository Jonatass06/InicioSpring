package net.weg.api.repository;

import net.weg.api.repository.CarroDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/db_integracao";
    private static final String USERNAME = "root";
    private static final String SENHA = "root";

    public static Connection conectar() {
        try{
            return DriverManager.getConnection(URL_BANCO, USERNAME, SENHA);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


}

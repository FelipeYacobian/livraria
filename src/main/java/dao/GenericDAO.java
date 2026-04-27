package dao;

import java.sql.*;

public class GenericDAO {
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Livraria",
                "root",
                "root"
        );
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hiep0
 */
public class CSDL {

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/QuanLyKhachSan";
            String userName = "root";
            String passwordUser = "123456789";
            conn = DriverManager.getConnection(urlDB, userName, passwordUser);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }
}

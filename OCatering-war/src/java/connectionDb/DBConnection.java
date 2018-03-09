/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectionDb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Khanh
 */
public class DBConnection {
    private static Connection conn;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:1433/OnlineCatering";
    private static String USER = "sa";
    private static String PASS = "sa";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}

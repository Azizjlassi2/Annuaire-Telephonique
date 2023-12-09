package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static Connection conn = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String dataBaseName = "jdbc:mysql://localhost:3306/";
    static String userName = "root";
    static String passwod = "";

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            // Charger la classe de pilote (driver)
            Class.forName("com.mysql.jdbc.Driver");

            // Établir la connexion avec la base de données
            conn = DriverManager.getConnection(
                    url + dataBaseName, userName, passwod);

            System.out.println("Connexion réussie");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connexion échouée : " + e.getMessage());
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connexion fermée avec succès");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}

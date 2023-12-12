package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Personne;
import Models.Telephonne;

public class TelephonneDAOImpl implements TelephonneDAO {

    @Override
    public List<Telephonne> getAllTelephonne() {
        List<Telephonne> telephonnes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Connexion.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM telephonne");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Telephonne telephonne = new Telephonne(0, null, 0);

                telephonne.setValeur(resultSet.getInt("valeur"));
                telephonne.setType(resultSet.getString("type"));
                telephonne.setCinPersonne(resultSet.getInt("personne_id"));

                telephonnes.add(telephonne);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return telephonnes.isEmpty() ? null : telephonnes;
    }

    @Override
    public Telephonne getTelephonne(int valeur) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Telephonne telephonne = new Telephonne(0, null, 0);

        try {
            connection = Connexion.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM telephonne WHERE valeur = ?");
            preparedStatement.setInt(1, valeur);

            resultSet = preparedStatement.executeQuery();

            telephonne.setValeur(resultSet.getInt("valeur"));
            telephonne.setType(resultSet.getString("type"));
            telephonne.setCinPersonne(resultSet.getInt("personne_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return telephonne != null ? telephonne : null;
    }

    @Override
    public void updateTelephonne(Telephonne telephonne) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "UPDATE telephonne SET type = ?, personne_id = ? WHERE valeur = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set values for the PreparedStatement
            preparedStatement.setString(1, telephonne.getType());
            preparedStatement.setInt(2, telephonne.getCinPersonne());
            preparedStatement.setInt(3, telephonne.getValeur());

            // Execute the update
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of creation
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteTelephonne(int personne_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "DELETE FROM telephonne WHERE personne_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the value for the PreparedStatement
            preparedStatement.setInt(1, personne_id);

            // Execute the delete
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of creation
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void ajouterTelephonne(Personne personne, Telephonne telephone) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "INSERT INTO telephonne (valeur, type, personne_id) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set values for the PreparedStatement
            preparedStatement.setInt(1, telephone.getValeur());
            preparedStatement.setString(2, telephone.getType());
            preparedStatement.setInt(3, personne.getCin());

            // Execute the insert
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of creation
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

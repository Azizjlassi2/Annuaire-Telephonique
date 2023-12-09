package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Personne;

public class PersonneDAOImpl implements PersonneDAO {

    @Override
    public List<Personne> getAllPersonne() {
        List<Personne> personnes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Connexion.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM personne");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Personne personne = new Personne(0, null, null, null);

                personne.setCin(resultSet.getInt("cin"));
                personne.setNom(resultSet.getString("nom"));
                personne.setPrenom(resultSet.getString("prenom"));

                personnes.add(personne);
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

        return personnes.isEmpty() ? null : personnes;
    }

    @Override
    public Personne getPersonne(int cin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Personne personne = new Personne(0, null, null, null);

        try {
            connection = Connexion.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM personne WHERE cin = ?");
            preparedStatement.setInt(1, cin);
            resultSet = preparedStatement.executeQuery();

            personne.setCin(resultSet.getInt("cin"));
            personne.setNom(resultSet.getString("nom"));
            personne.setPrenom(resultSet.getString("prenom"));

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

        return personne != null ? personne : null;
    }

    @Override
    public void updatePersonne(Personne personne) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "UPDATE personne SET nom = ?, prenom = ? WHERE cin = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set values for the PreparedStatement
            preparedStatement.setString(1, personne.getNom());
            preparedStatement.setString(2, personne.getPrenom());
            preparedStatement.setInt(3, personne.getCin());

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
    public void deletePersonne(int cin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "DELETE FROM personne WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the value for the PreparedStatement
            preparedStatement.setInt(1, cin);

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
    public void ajouterPersonne(Personne personne) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Connexion.getConnection();
            String sql = "UPDATE personne SET nom = ?, prenom = ? WHERE cin = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set values for the PreparedStatement
            preparedStatement.setString(1, personne.getNom());
            preparedStatement.setString(2, personne.getPrenom());
            preparedStatement.setInt(3, personne.getCin());

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

}

package db;

import java.sql.*;
import characters.Character;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/dnd_game";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Ouvre une connexion à la BDD
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Teste si la connexion fonctionne
    public static void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Connexion à la base de données réussie !");
        } catch (SQLException e) {
            System.err.println("Échec de la connexion : " + e.getMessage());
        }
    }

    // Affiche tous les personnages enregistrés
    public static void getHeroes() {
        String query = "SELECT * FROM `Character`";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("--- Liste des personnages ---");
            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("Id") +
                                " | Type: " + resultSet.getString("Type") +
                                " | Nom: " + resultSet.getString("Name") +
                                " | PV: " + resultSet.getInt("LifePoints") +
                                " | Force: " + resultSet.getInt("Strength") +
                                " | Équipement: " + resultSet.getString("OffensiveEquipment")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur getHeroes : " + e.getMessage());
        }
    }

    // Enregistre un nouveau personnage en BDD
    public static void createHero(Character character) {
        String query = "INSERT INTO `Character` (Type, Name, LifePoints, Strength, OffensiveEquipment, DefensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             //GENERATED_KEYS demande à MySQL de retourner l'id créé
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, character.getClass().getSimpleName());
            ps.setString(2, character.getName());
            ps.setInt(3, character.getLife());
            ps.setInt(4, character.getAttack());
            ps.setString(5, null);
            ps.setString(6, null);
            ps.executeUpdate();

            //Récupère l'id auto-généré et le stocke dans l'objet
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                character.setId(generatedKeys.getInt(1));
                System.out.println("Personnage enregistré avec l'id : " + character.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erreur createHero : " + e.getMessage());
        }
    }

    // Met à jour toutes les infos d'un perso existant
    public static void editHero(Character character) {
        String query = "UPDATE `Character` SET LifePoints = ?, Strength = ?, OffensiveEquipment = ? WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, character.getLife());
            ps.setInt(2, character.getAttack());
            ps.setString(3, character.getOffensiveEquipment() != null
                    ? character.getOffensiveEquipment().toString()
                    : null);
            ps.setInt(4, character.getId());
            ps.executeUpdate();
            System.out.println("Personnage mis à jour !");
        } catch (SQLException e) {
            System.err.println("Erreur editHero : " + e.getMessage());
        }
    }
}
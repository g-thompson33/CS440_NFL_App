package com.example.CS440_Application.dao;

import com.example.CS440_Application.entity.Players;
import com.example.CS440_Application.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CREATE TABLE Player (
// Team VARCHAR(255),
//Player_ID INT PRIMARY KEY,
//FOREIGN KEY (Team)  REFERENCES Team(Name),
//Position VARCHAR(50) NOT NULL,
//Number INT NOT NULL,
//Name VARCHAR(255) NOT NULL
//);
public class PlayersDAO {
    private static final String SELECT_ALL_PLAYERS = "SELECT * FROM Player ORDER BY name asc";

    public List<Players> getAllPlayers() {
        List<Players> players = new ArrayList<>();
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PLAYERS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Players player = new Players(
                        resultSet.getString("Name"),
                        resultSet.getString("Team"),
                        resultSet.getString("Position"),
                        resultSet.getInt("Player_ID"),
                        resultSet.getInt("Number")
                );
                players.add(player);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
        return players;
    }

    public void addPlayer(Players player) {
        String sql = "INSERT INTO Player (Name, Team, Position, Player_ID, Number) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, player.getName());
            statement.setString(2, player.getTeam());
            statement.setString(3, player.getPosition());
            statement.setInt(4, player.getPlayer_ID());
            statement.setInt(5, player.getNumber());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
    }

}
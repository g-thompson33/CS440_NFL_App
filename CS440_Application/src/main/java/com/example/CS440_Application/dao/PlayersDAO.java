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







}
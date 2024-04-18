package com.example.CS440_Application.dao;

import com.example.CS440_Application.entity.Team;
import com.example.CS440_Application.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private static final String SELECT_ALL_TEAMS = "SELECT * FROM Team ORDER BY name asc";

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TEAMS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Populate Team objects from result set and add them to the list
                Team team = new Team(resultSet.getString("Name"), resultSet.getString("City"),
                        resultSet.getString("Mascot"), resultSet.getString("Coach"),
                        resultSet.getString("Stadium"), resultSet.getString("Division"),
                        resultSet.getString("Record"));
                teams.add(team);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return teams;
    }
}


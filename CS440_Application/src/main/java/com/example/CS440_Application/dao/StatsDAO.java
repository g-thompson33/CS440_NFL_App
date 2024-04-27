package com.example.CS440_Application.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatsDAO {
    private static final String SELECT_STATS_BY_PLAYER_ID_AND_WEEK =
            "SELECT * FROM Player_Stats WHERE Player_ID = ? AND Week = ?";
    private static final String INSERT_STATS =
            "INSERT INTO Player_Stats (Player_ID, Week, Rushing_Attempts, Rushing_Yards, Receptions, Receiving_Yards, Passing_Attempts, Passing_Yards, Touchdowns, Interceptions, Fumbles) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_STATS =
            "UPDATE Player_Stats SET Rushing_Attempts = ?, Rushing_Yards = ?, Receptions = ?, Receiving_Yards = ?, Passing_Attempts = ?, Passing_Yards = ?, Touchdowns = ?, Interceptions = ?, Fumbles = ? " +
                    "WHERE Player_ID = ? AND Week = ?";

    public PlayerStats getStatsByPlayerIdAndWeek(int playerId, int week) {
        PlayerStats stats = null;
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_STATS_BY_PLAYER_ID_AND_WEEK)) {
            statement.setInt(1, playerId);
            statement.setInt(2, week);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                stats = new PlayerStats(
                        playerId,
                        week,
                        resultSet.getInt("Rushing_Attempts"),
                        resultSet.getInt("Rushing_Yards"),
                        resultSet.getInt("Receptions"),
                        resultSet.getInt("Receiving_Yards"),
                        resultSet.getInt("Passing_Attempts"),
                        resultSet.getInt("Passing_Yards"),
                        resultSet.getInt("Touchdowns"),
                        resultSet.getInt("Interceptions"),
                        resultSet.getInt("Fumbles")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
        return stats;
    }

    public void addStats(PlayerStats stats) {
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STATS)) {
            statement.setInt(1, stats.getPlayerId());
            statement.setInt(2, stats.getWeek());
            statement.setInt(3, stats.getRushingAttempts());
            statement.setInt(4, stats.getRushingYards());
            statement.setInt(5, stats.getReceptions());
            statement.setInt(6, stats.getReceivingYards());
            statement.setInt(7, stats.getPassingAttempts());
            statement.setInt(8, stats.getPassingYards());
            statement.setInt(9, stats.getTouchdowns());
            statement.setInt(10, stats.getInterceptions());
            statement.setInt(11, stats.getFumbles());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
    }

    public void updateStats(PlayerStats stats) {
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STATS)) {
            statement.setInt(1, stats.getRushingAttempts());
            statement.setInt(2, stats.getRushingYards());
            statement.setInt(3, stats.getReceptions());
            statement.setInt(4, stats.getReceivingYards());
            statement.setInt(5, stats.getPassingAttempts());
            statement.setInt(6, stats.getPassingYards());
            statement.setInt(7, stats.getTouchdowns());
            statement.setInt(8, stats.getInterceptions());
            statement.setInt(9, stats.getFumbles());
            statement.setInt(10, stats.getPlayerId());
            statement.setInt(11, stats.getWeek());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
    }
}


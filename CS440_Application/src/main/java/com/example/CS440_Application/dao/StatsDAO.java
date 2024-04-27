package com.example.CS440_Application.dao;
import com.example.CS440_Application.entity.PlayerStats;
import com.example.CS440_Application.util.DatabaseConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatsDAO {
    private static final String SELECT_STATS_BY_PLAYER_ID=
            "SELECT * FROM Player_Stats WHERE Player_ID = ?";
    private static final String INSERT_STATS =
            "INSERT INTO Player_Stats (Player_ID, Week, Rushing_Attempts, Rushing_Yards, Receptions, Receiving_Yards, Passing_Attempts, Passing_Yards, Touchdowns, Interceptions, Fumbles) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STATS =
            "SELECT * FROM Player_Stats";
    private static final String UPDATE_STATS =
            "UPDATE Player_Stats SET Rushing_Attempts = ?, Rushing_Yards = ?, Receptions = ?, Receiving_Yards = ?, Passing_Attempts = ?, Passing_Yards = ?, Touchdowns = ?, Interceptions = ?, Fumbles = ? " +
                    "WHERE Player_ID = ? AND Week = ?";



    public static List<PlayerStats> getAllStats() {
        List<PlayerStats> statsList = new ArrayList<>();
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STATS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PlayerStats stats = new PlayerStats(
                        resultSet.getInt("Player_ID"),
                        resultSet.getInt("Week"),
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
                statsList.add(stats);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();  // Consider logging this error appropriately
        }
        return statsList;
    }


//    public void addStats(PlayerStats stats) {
//        try (Connection connection = DatabaseConnectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT_STATS)) {
//            statement.setInt(1, stats.getPlayerID());
//            statement.setInt(2, stats.getWeek());
//            statement.setInt(3, stats.getRushingAttempts());
//            statement.setInt(4, stats.getRushingYards());
//            statement.setInt(5, stats.getReceptions());
//            statement.setInt(6, stats.getReceivingYards());
//            statement.setInt(7, stats.getPassingAttempts());
//            statement.setInt(8, stats.getPassingYards());
//            statement.setInt(9, stats.getTouchdowns());
//            statement.setInt(10, stats.getInterceptions());
//            statement.setInt(11, stats.getFumbles());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();  // Consider logging this error appropriately
//        }
//    }
//
//    public void updateStats(PlayerStats stats) {
//        try (Connection connection = DatabaseConnectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_STATS)) {
//            statement.setInt(1, stats.getRushingAttempts());
//            statement.setInt(2, stats.getRushingYards());
//            statement.setInt(3, stats.getReceptions());
//            statement.setInt(4, stats.getReceivingYards());
//            statement.setInt(5, stats.getPassingAttempts());
//            statement.setInt(6, stats.getPassingYards());
//            statement.setInt(7, stats.getTouchdowns());
//            statement.setInt(8, stats.getInterceptions());
//            statement.setInt(9, stats.getFumbles());
//            statement.setInt(10, stats.getPlayerID());
//            statement.setInt(11, stats.getWeek());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();  // Consider logging this error appropriately
//        }
//    }


}


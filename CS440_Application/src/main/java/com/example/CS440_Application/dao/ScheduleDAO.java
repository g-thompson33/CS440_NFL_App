package com.example.CS440_Application.dao;

import com.example.CS440_Application.entity.Schedule;
import com.example.CS440_Application.util.DatabaseConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private static final String SELECT_ALL_SCHEDULES = "SELECT * FROM Schedule ORDER BY Team asc";

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = DatabaseConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SCHEDULES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Populate Schedule objects from result set and add them to the list
                Schedule schedule = new Schedule(resultSet.getString("Team"), resultSet.getString("Opponent"),
                        resultSet.getString("Week"));
                schedules.add(schedule);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return schedules;
    }
}


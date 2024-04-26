package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.ScheduleDAO;
import com.example.CS440_Application.entity.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ScheduleController {
    private final ScheduleDAO scheduleDAO = new ScheduleDAO();

    @GetMapping("/schedule")
    public String getAllSchedules(Model model) {
        model.addAttribute("schedules", scheduleDAO.getAllSchedules());
        return "schedule"; // View name (Thymeleaf template)
    }

    @GetMapping("/schedule/{team}")
    public String viewSchedule(@PathVariable("team") String team, Model model) {
        List<Schedule> teamSchedule = scheduleDAO.getScheduleByTeam(team);// Change to a different view for team schedule
        model.addAttribute("schedules", teamSchedule);
        return "teamSchedule";
    }
}
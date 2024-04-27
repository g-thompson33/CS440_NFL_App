package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.ScheduleDAO;
import com.example.CS440_Application.dao.StatsDAO;
import com.example.CS440_Application.entity.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class statsController {
    private final StatsDAO statsDAO = new StatsDAO();

    @GetMapping("/stats")
    public String getAllStats(Model model) {
        model.addAttribute("stats", StatsDAO.getAllStats());
        return "stats"; // View name (Thymeleaf template)
    }

    @GetMapping("/stats/{id}")
    public String viewSchedule(@PathVariable("id") String id, Model model) {
        List<Schedule> playerStats = StatsDAO.getStatsById(id);
        model.addAttribute("playerStats", playerStats);
        return "playerStats";
    }
}
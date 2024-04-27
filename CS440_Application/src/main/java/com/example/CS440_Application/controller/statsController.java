package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.ScheduleDAO;
import com.example.CS440_Application.dao.StatsDAO;
import com.example.CS440_Application.entity.PlayerStats;
import com.example.CS440_Application.entity.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class statsController {
    private final StatsDAO statsDAO = new StatsDAO();

    @GetMapping("/playerStats")
    public String getAllStats(Model model) {
        model.addAttribute("playerStats", StatsDAO.getAllStats());
        return "playerStats"; // View name (Thymeleaf template)
    }

//    @GetMapping("/playerStats/{id}")
//    public String viewSchedule(@PathVariable("id") int id, Model model) {
//        List<PlayerStats> playerStats = StatsDAO.getStatsByID(id);
//        model.addAttribute("playerStats", playerStats);
//        return "playerStats";
//    }
}
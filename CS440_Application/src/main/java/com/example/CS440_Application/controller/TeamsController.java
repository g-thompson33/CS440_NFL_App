package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.TeamDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamsController {
    private final TeamDAO teamDAO = new TeamDAO();

    @GetMapping("/teams")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamDAO.getAllTeams());
        return "teamList"; // View name (Thymeleaf template)
    }
}
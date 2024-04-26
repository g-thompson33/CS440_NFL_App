package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.PlayersDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class playerController {
    private final PlayersDAO playersDAO = new PlayersDAO();

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playersDAO.getAllPlayers());
        return "playerList"; // View name (Thymeleaf template)
    }
}
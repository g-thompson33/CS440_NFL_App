package com.example.CS440_Application.controller;
import com.example.CS440_Application.entity.Players;
import com.example.CS440_Application.dao.PlayersDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class playerController {
    private final PlayersDAO playersDAO = new PlayersDAO();

    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playersDAO.getAllPlayers());
        return "playerList"; // View name (Thymeleaf template)
    }

    @GetMapping("/addPlayer")
    public String showAddPlayerForm(Model model) {
        model.addAttribute("player", new Players());
        return "addPlayer"; // This will resolve to addPlayer.html
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@ModelAttribute("player") Players player) {
        playersDAO.addPlayer(player);
        return "redirect:/playerList"; // Redirect to players list page after adding player
    }

}
package com.example.CS440_Application.controller;

import com.example.CS440_Application.dao.ScheduleDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {
    private final ScheduleDAO scheduleDAO = new ScheduleDAO();

    @GetMapping("/schedule")
    public String getAllSchedules(Model model) {
        model.addAttribute("schedules", scheduleDAO.getAllSchedules());
        return "schedule"; // View name (Thymeleaf template)
    }
}
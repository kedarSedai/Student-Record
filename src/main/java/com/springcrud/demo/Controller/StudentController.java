package com.springcrud.demo.Controller;

import com.springcrud.demo.Service.StudnetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {

    @Autowired
    private StudnetServiceImpl studnetService;

    @GetMapping("/")
    private String homePage(Model model) {
        model.addAttribute("listStudent", studnetService.getAllStudents());
        return "index";
    }
}

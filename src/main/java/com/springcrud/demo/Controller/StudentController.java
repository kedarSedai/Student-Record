package com.springcrud.demo.Controller;

import com.springcrud.demo.Entity.Student;
import com.springcrud.demo.Service.StudnetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudnetServiceImpl studnetService;

    @GetMapping("/")
    public String homePage(Model model) {
//        model.addAttribute("listStudent", studnetService.getAllStudents());
//        return "index";
        List<Student> listStudent = studnetService.getAllStudents();
        model.addAttribute("listStudent", listStudent);
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        Student student = new Student();
//        model.addAttribute("student", new Student());
        model.addAttribute("student", student);
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        studnetService.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable(name = "id") int id) {
        ModelAndView modelView = new ModelAndView("new");
        Student student = studnetService.getStudentById(id);
        modelView.addObject("student", student);
        return modelView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studnetService.deleteById(id);
        return "redirect:/";
    }
}

package mk.ukim.finki.dians.facultyapp.web.controller;

import mk.ukim.finki.dians.facultyapp.model.Faculty;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {


    public HomeController() {

    }

    @GetMapping(value = {"/home", ""})
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/aboutUs")
    public String getAboutUsPage() {
        return "aboutUs";
    }

}

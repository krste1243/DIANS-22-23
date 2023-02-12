package mk.ukim.finki.dians.facultyapp.web.controller;

import mk.ukim.finki.dians.facultyapp.service.CityService;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String getCitiesPage(Model model) {
        model.addAttribute("cities", cityService.listAllCities());
        return "cities";
    }
}

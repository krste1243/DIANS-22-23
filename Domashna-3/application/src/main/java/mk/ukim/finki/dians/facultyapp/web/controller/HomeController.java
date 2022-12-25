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

    private final FacultyService facultyService;

    public HomeController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(value = {"/home", ""})
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/aboutUs")
    public String getAboutUsPage() {
        return "aboutUs";
    }

    @GetMapping("/cities")
    public String getCitiesPage(Model model) {
        model.addAttribute("cities", facultyService.listAllCities());
        return "cities";
    }

    @GetMapping("/faculty")
    public String getFacultyPage(@RequestParam String facultyName,@RequestParam String city, Model model) {
        Faculty faculty = facultyService.findFacultyByNameAndCity(facultyName, city).orElseThrow(RuntimeException::new);
        model.addAttribute("faculty", faculty);
        if(faculty.getName().toLowerCase().contains("suli")) {
            model.addAttribute("imgPath", "Faculty-of-Visual-Arts-Suli-An-Skopje.jpg");
        }
        else if(faculty.getName().toLowerCase().contains("&")) {
            model.addAttribute("imgPath", "Faculty-of-Civil-Engineering-&-Architecture-Skopje.jpg");
        }
        else if(faculty.getName().toLowerCase().contains("uklo")) {
            model.addAttribute("imgPath", "UKLO-Faculty-for-Economics-Prilep.jpg");
        }
        else {
            model.addAttribute("imgPath", faculty.getName().trim().replace(" ","-") + "-" + faculty.getCity().getCity() + ".jpg");
        }
        return "faculty";
    }

    @GetMapping("/faculties")
    public String getFacultiesPage(@RequestParam(required = false) String city, Model model) {
        if(city != null && !city.isEmpty()) {
            model.addAttribute("faculties", facultyService.searchFacultiesByCity(city));
        }
        else {
            model.addAttribute("faculties", facultyService.listAllFaculties());
        }
        return "faculties";
    }
}

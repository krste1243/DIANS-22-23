package mk.ukim.finki.dians.facultyservice.controller;

import mk.ukim.finki.dians.facultyservice.dto.FacultyResponse;
import mk.ukim.finki.dians.facultyservice.service.FacultyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping()
    public FacultyResponse getFaculty(@RequestParam String facultyName, @RequestParam String city) {
        return facultyService.findFacultyByNameAndCity(facultyName, city).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/faculties")
    public List<FacultyResponse> getFacultiesPage(@RequestParam(required = false) String city) {
        if(city != null && !city.isEmpty()) {
            return facultyService.searchFacultiesByCity(city);
        }
        else {
            return facultyService.listAllFaculties();
        }
    }
}

package mk.ukim.finki.dians.facultyapp.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.dians.facultyapp.dto.CityResponse;
import mk.ukim.finki.dians.facultyapp.dto.FacultyResponse;
import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FacultyController {

    private final FacultyService facultyService;
    private final RestTemplate restTemplate;

    public FacultyController(FacultyService facultyService, RestTemplate restTemplate) {
        this.facultyService = facultyService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/faculty")
    public String getFacultyPage(@RequestParam String facultyName, @RequestParam String city, Model model) {
        //Call GET action to the Faculty Microservice with query parameters for the faculty name and city and receive a FacultyResponse object
        String url = "http://localhost:8086/api/faculty?facultyName=" + facultyName + "&city=" + city;
        FacultyResponse facultyResponse = restTemplate.getForObject(url, FacultyResponse.class);
        //Map the facultyResponse object to a Faculty object so that it can be displayed in the view
        Faculty faculty = facultyResponse.getFaculty();
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
        ObjectMapper mapper = new  ObjectMapper();
        String url = "http://localhost:8086/api/faculty/faculties";
        if(city != null && !city.isEmpty()) {
            url+="?city="+city;
        }
            //Call a GET request to the URL of the Faculty Microservice and get the response object which returns List<LinkedHashMap>
            List<FacultyResponse> response =  restTemplate.getForObject(
                    url, List.class);
            //Convert the response to a List of FacultyResponse
            List<FacultyResponse> facultyResponses = mapper.convertValue(response, new TypeReference<List<FacultyResponse>>() {});
            //Map each FacultyResponse object to Faculty object so that it can be passed to the model for displaying in the view
            List<Faculty> allFaculties = facultyResponses.stream().map(FacultyResponse::getFaculty).collect(Collectors.toList());
            model.addAttribute("faculties", allFaculties);
        return "faculties";
    }

}

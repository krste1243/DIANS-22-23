package mk.ukim.finki.dians.facultyapp.web.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.dians.facultyapp.dto.CityResponse;
import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CityController {
    private final CityService cityService;
    private final RestTemplate restTemplate;

    public CityController(CityService cityService, RestTemplate restTemplate) {
        this.cityService = cityService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cities")
    public String getCitiesPage(Model model) {
        ObjectMapper mapper = new  ObjectMapper();
        //Call a GET request to the URL of the City Microservice and get the response object which returns List<LinkedHashMap>
        List<CityResponse> response =  restTemplate.getForObject(
                "http://localhost:8086/api/city", List.class);
        //Convert the response to a List of CityResponses
        List<CityResponse> cityResponses = mapper.convertValue(response, new TypeReference<List<CityResponse>>() {});
        //Map each CityResponse object to City object so that it can be passed to the model for displaying in the view
        List<City> allCities = cityResponses.stream().map(CityResponse::getCity).collect(Collectors.toList());
        model.addAttribute("cities", allCities);
        return "cities";
    }
}

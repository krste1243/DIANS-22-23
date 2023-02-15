package mk.ukim.finki.dians.cityservice.controller;

import mk.ukim.finki.dians.cityservice.dto.CityResponse;
import mk.ukim.finki.dians.cityservice.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponse> getAllCities() {
        return cityService.listAllCities();
    }

    @GetMapping("/{city}")
    @ResponseStatus(HttpStatus.OK)
    public CityResponse getCity(@PathVariable String city) throws Exception {
        return cityService.findCityByName(city).orElseThrow(Exception::new);
    }
}

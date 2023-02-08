package mk.ukim.finki.dians.facultyapp.service;

import mk.ukim.finki.dians.facultyapp.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> listAllCities();
    Optional<City> findCityByName(String city);
}

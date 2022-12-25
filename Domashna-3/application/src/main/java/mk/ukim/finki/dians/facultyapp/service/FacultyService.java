package mk.ukim.finki.dians.facultyapp.service;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<Faculty> listAllFaculties();
    List<City> listAllCities();
    List<Faculty> searchFacultiesByCity(String city);
    Optional<Faculty> findFacultyByNameAndCity(String name, String city);
    Optional<City> findCityByName(String city);
}

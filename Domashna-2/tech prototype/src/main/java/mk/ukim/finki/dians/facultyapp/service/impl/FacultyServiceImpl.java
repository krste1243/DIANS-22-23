package mk.ukim.finki.dians.facultyapp.service.impl;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;
import mk.ukim.finki.dians.facultyapp.repository.CityRepository;
import mk.ukim.finki.dians.facultyapp.repository.FacultyRepository;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final CityRepository cityRepository;
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(CityRepository cityRepository, FacultyRepository facultyRepository) {
        this.cityRepository = cityRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public List<Faculty> listAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<Faculty> searchFacultiesByCity(String city) {
        return facultyRepository.findAllByCity(cityRepository.findById(city).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Faculty> findFacultyByNameAndCity(String name, String city) {
        return facultyRepository.findByNameAndCity(name, findCityByName(city).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<City> findCityByName(String city) {
        return cityRepository.findById(city);
    }


}

package mk.ukim.finki.dians.facultyapp.service.impl;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;
import mk.ukim.finki.dians.facultyapp.repository.CityRepository;
import mk.ukim.finki.dians.facultyapp.repository.FacultyRepository;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

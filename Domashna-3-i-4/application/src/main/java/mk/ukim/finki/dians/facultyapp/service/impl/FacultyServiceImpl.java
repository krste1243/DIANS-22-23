package mk.ukim.finki.dians.facultyapp.service.impl;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;
import mk.ukim.finki.dians.facultyapp.repository.FacultyRepository;
import mk.ukim.finki.dians.facultyapp.service.CityService;
import mk.ukim.finki.dians.facultyapp.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final CityService cityService;

    public FacultyServiceImpl(FacultyRepository facultyRepository, CityService cityService) {
        this.facultyRepository = facultyRepository;
        this.cityService = cityService;
    }

    @Override
    public List<Faculty> listAllFaculties() {
        return facultyRepository.findAll();
    }


    @Override
    public List<Faculty> searchFacultiesByCity(String city) {
        return facultyRepository.findAllByCity(cityService.findCityByName(city).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Faculty> findFacultyByNameAndCity(String name, String city) {
        return facultyRepository.findByNameAndCity(name, cityService.findCityByName(city).orElseThrow(RuntimeException::new));
    }


}

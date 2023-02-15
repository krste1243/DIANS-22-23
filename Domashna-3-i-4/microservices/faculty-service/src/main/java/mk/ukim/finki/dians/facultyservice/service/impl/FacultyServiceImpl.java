package mk.ukim.finki.dians.facultyservice.service.impl;


import mk.ukim.finki.dians.facultyservice.dto.FacultyResponse;
import mk.ukim.finki.dians.facultyservice.model.Faculty;
import mk.ukim.finki.dians.facultyservice.repository.CityRepository;
import mk.ukim.finki.dians.facultyservice.repository.FacultyRepository;
import mk.ukim.finki.dians.facultyservice.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final CityRepository cityRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository, CityRepository cityRepository) {
        this.facultyRepository = facultyRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<FacultyResponse> listAllFaculties() {
        return facultyRepository.findAll().stream().map(this::mapToFacultyResponse).toList();
    }


    @Override
    public List<FacultyResponse> searchFacultiesByCity(String city) {
        return facultyRepository.findAllByCity(cityRepository.findById(city).orElseThrow(RuntimeException::new)).stream().map(this::mapToFacultyResponse).toList();
    }

    @Override
    public Optional<FacultyResponse> findFacultyByNameAndCity(String name, String city) {
        return facultyRepository.findByNameAndCity(name, cityRepository.findById(city).orElseThrow(RuntimeException::new)).map(this::mapToFacultyResponse);
    }

    private FacultyResponse mapToFacultyResponse(Faculty faculty) {
        return FacultyResponse.builder().faculty(faculty).build();
    }


}
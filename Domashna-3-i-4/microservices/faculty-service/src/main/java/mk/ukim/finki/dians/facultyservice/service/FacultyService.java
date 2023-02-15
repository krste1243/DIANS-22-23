package mk.ukim.finki.dians.facultyservice.service;

import mk.ukim.finki.dians.facultyservice.dto.FacultyResponse;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    List<FacultyResponse> listAllFaculties();
    List<FacultyResponse> searchFacultiesByCity(String city);
    Optional<FacultyResponse> findFacultyByNameAndCity(String name, String city);
}
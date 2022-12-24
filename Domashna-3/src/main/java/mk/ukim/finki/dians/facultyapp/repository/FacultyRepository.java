package mk.ukim.finki.dians.facultyapp.repository;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    public List<Faculty> findAllByCity(City city);
    Optional<Faculty> findByNameAndCity(String name, City city);
}

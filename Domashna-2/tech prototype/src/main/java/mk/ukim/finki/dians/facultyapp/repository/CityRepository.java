package mk.ukim.finki.dians.facultyapp.repository;

import mk.ukim.finki.dians.facultyapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}

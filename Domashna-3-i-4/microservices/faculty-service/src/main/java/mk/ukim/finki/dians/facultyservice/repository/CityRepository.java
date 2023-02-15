package mk.ukim.finki.dians.facultyservice.repository;

import mk.ukim.finki.dians.facultyservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}


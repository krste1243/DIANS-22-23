package mk.ukim.finki.dians.cityservice.repository;

import mk.ukim.finki.dians.cityservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
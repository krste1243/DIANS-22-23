package mk.ukim.finki.dians.cityservice.service;

import mk.ukim.finki.dians.cityservice.dto.CityResponse;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityResponse> listAllCities();
    Optional<CityResponse> findCityByName(String city);
}


package mk.ukim.finki.dians.cityservice.service.impl;

import mk.ukim.finki.dians.cityservice.dto.CityResponse;
import mk.ukim.finki.dians.cityservice.model.City;
import mk.ukim.finki.dians.cityservice.repository.CityRepository;
import mk.ukim.finki.dians.cityservice.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityResponse> listAllCities() {
        return cityRepository.findAll().stream().map(this::mapToCityResponse).toList();
    }

    @Override
    public Optional<CityResponse> findCityByName(String city) {
        return cityRepository.findById(city).map(this::mapToCityResponse);
    }

    private CityResponse mapToCityResponse(City city) {
        return CityResponse.builder().city(city).build();
    }
}
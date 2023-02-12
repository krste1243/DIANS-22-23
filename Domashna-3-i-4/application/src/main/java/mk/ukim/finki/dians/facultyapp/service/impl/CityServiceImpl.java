package mk.ukim.finki.dians.facultyapp.service.impl;

import mk.ukim.finki.dians.facultyapp.model.City;
import mk.ukim.finki.dians.facultyapp.repository.CityRepository;
import mk.ukim.finki.dians.facultyapp.service.CityService;
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
    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findCityByName(String city) {
        return cityRepository.findById(city);
    }
}

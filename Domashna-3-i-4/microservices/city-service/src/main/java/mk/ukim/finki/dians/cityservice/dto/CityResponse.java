package mk.ukim.finki.dians.cityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians.cityservice.model.City;
import mk.ukim.finki.dians.cityservice.model.Faculty;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {
    City city;
}

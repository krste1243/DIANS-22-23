package mk.ukim.finki.dians.facultyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians.facultyapp.model.City;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {
    City city;
}

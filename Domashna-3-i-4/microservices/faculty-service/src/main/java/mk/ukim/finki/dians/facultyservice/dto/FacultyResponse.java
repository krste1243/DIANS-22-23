package mk.ukim.finki.dians.facultyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians.facultyservice.model.Faculty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultyResponse {
    Faculty faculty;
}

package mk.ukim.finki.dians.facultyapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City {
    @Id
    String city;
    @OneToMany
    List<Faculty> faculties;
}

package mk.ukim.finki.dians.facultyservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City {
    @Id
    String city;
    @OneToMany(fetch = FetchType.EAGER)
    List<Faculty> faculties;
}
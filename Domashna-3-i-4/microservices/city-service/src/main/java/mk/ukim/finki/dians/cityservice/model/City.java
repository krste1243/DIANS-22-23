package mk.ukim.finki.dians.cityservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Getter
public class City {
    @Id
    String city;
    @OneToMany(fetch = FetchType.EAGER)
    List<Faculty> faculties;
}

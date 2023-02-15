package mk.ukim.finki.dians.cityservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Faculty {
    @Id
    Long id;

    String name;

    @ManyToOne
    City city;

    Double latitude;

    Double longitude;
}


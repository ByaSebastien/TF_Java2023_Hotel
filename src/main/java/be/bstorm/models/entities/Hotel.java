package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Hotel extends BaseEntity<Long>{

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    private int stars;

    @OneToOne
    private Worker leader;

    @ManyToMany
    @JoinTable(
            name = "Hotel_Worker",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
    private List<Worker> workers;
}

package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Room extends BaseEntity<Long> {

    @Column(nullable = false)
    private String number;

    @ElementCollection
    private List<String> features;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}

package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter @Setter
public class BaseEntity<T extends Serializable> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}

package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class Worker extends BaseEntity<Long>{

    @Column(unique = true,updatable = false,nullable = false,length = 25)
    private String matricule;

    @Column(nullable = false,length = 50)
    private String lastname;

    @Column(nullable = false,length = 50)
    private String firstname;

    @Embedded
    private Address address;

    @Column(unique = true,nullable = false,length = 100)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

    public Worker(String matricule, String lastname, String firstname, Address address, String email, String phoneNumber) {
        this.matricule = matricule;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

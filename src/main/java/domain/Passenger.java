package domain;

import base.BaseEntity;
import enumiration.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Passenger extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}


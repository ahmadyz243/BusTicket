package domain;

import base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ComService extends BaseEntity {
    private String originCity;
    private String destinationCity;
    private int emptySeats;
    private int price;
    private Date DateAndTimeOfDeparture;

    @ManyToOne
    private Company company;

    @Override
    public String toString() {
        return "service id = "+ getId() +
                " origin City= " + originCity + '\'' +
                " destination City= " + destinationCity + '\'' +
                ", empty Seats= " + emptySeats +
                ", price= " + price +
                "\n , Date And Time Of Departure= " + DateAndTimeOfDeparture +
                ", company= " + company.getName() + "\n --------------------------------------------------------------";
    }
}

package domain;

import base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.TimeZone;


@NoArgsConstructor
@Setter@Getter
@Entity
public class Ticket extends BaseEntity {
    private String origin;
    private String destination;
    private Date date;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private ComService service;
}

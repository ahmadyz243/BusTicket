package repository;

import base.BaseRepository;
import domain.Passenger;

public interface PassengerRepository extends BaseRepository<Passenger> {
    boolean existsByUsername(String username);
    Passenger findByUsername(String username);
    void refreshPassenger(Passenger passenger);
}

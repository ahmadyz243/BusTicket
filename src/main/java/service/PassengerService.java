package service;

import base.BaseService;
import domain.Passenger;
import enumiration.Gender;

public interface PassengerService extends BaseService<Passenger> {
    boolean existsByUsername(String username);
    Passenger findByUsername(String username);
    Passenger signup(String firstname, String lastname, String username, String password, Gender gender);
    Passenger login(String username, String password);
    void refreshPassenger(Passenger passenger);
}
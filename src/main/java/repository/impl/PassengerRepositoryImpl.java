package repository.impl;

import base.BaseRepositoryImpl;
import domain.Passenger;
import repository.PassengerRepository;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger> implements PassengerRepository {
    @Override
    public Class<Passenger> getEntityClass() {
        return Passenger.class;
    }

    @Override
    public boolean existsByUsername(String username) {
        return em.createQuery("select (count (p) > 0) from Passenger p where p.userName =: username", Boolean.class)
                .setParameter("username", username).getSingleResult();
    }
    @Override
    public Passenger findByUsername(String username) {
        return em.createQuery("select p from Passenger p where p.userName =: username", Passenger.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public void refreshPassenger(Passenger passenger) {
        em.refresh(passenger);
    }
}

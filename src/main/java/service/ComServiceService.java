package service;

import base.BaseService;
import domain.ComService;
import domain.Company;

import java.util.Date;
import java.util.List;

public interface ComServiceService extends BaseService<ComService> {
    List<ComService> findByOriginAndDestination(String origin, String destination);
    List<ComService> searchServiceByOriginAndDestinationAndDate(String origin, String destination, Date date);
    ComService addNewService(Company company, String originCity, String destinationCity, int emptySeats, int price, Date dateAndTime);
    List<ComService> findByOriginAndDestinationAndDate(String origin, String destination, Date date);
    void deleteOldServices();
}


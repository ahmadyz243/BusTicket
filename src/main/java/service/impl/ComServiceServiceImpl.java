package service.impl;

import base.BaseServiceImpl;
import domain.ComService;
import domain.Company;

import org.joda.time.DateTimeComparator;
import repository.ComServiceRepository;
import service.ComServiceService;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ComServiceServiceImpl extends BaseServiceImpl<ComService, ComServiceRepository> implements ComServiceService {
    public ComServiceServiceImpl(ComServiceRepository repository) {
        super(repository);
    }



    @Override
    public List<ComService> findByOriginAndDestination(String origin, String destination) {
        try {
            return repository.findByOriginAndDestination(origin, destination);
        }catch (NoResultException e){
            return null;
        }
    }
    @Override
    public List<ComService> searchServiceByOriginAndDestinationAndDate(String origin, String destination, Date date) {
        List<ComService> services = findByOriginAndDestination(origin, destination);
        if(services == null || services.size() == 0){
            return null;
        }else {
            for (int i = 0; i < (services.size()); i++){
                DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();
                int retVal = dateTimeComparator.compare(date , services.get(i).getDateAndTimeOfDeparture());
                if(retVal != 0){
                    services.remove(i);
                    i--;
                }
            }
            return services;
        }
    }

    @Override
    public ComService addNewService(Company company, String originCity, String destinationCity, int emptySeats, int price, Date dateAndTime) {
        ComService comService = new ComService(originCity, destinationCity, emptySeats, price, dateAndTime, company);
        company.getServices().add(comService);
        save(comService);
        return comService;
    }

    @Override
    public List<ComService> findByOriginAndDestinationAndDate(String origin, String destination, Date date) {
        return repository.findByOriginAndDestinationAndDate(origin, destination, date);
    }

    @Override
    public void deleteOldServices() {
        beginTransAction();
        repository.deleteOldServices(new Date());
        commitTransaction();
    }
}

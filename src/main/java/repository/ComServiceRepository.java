package repository;

import base.BaseRepository;
import domain.ComService;

import java.util.Date;
import java.util.List;

public interface ComServiceRepository extends BaseRepository<ComService> {
    List<ComService> findByOriginAndDestination(String origin, String destination);
    List<ComService> findByOriginAndDestinationAndDate(String origin, String destination, Date date);
    void deleteOldServices(Date now);
}


package repository;

import base.BaseRepository;
import domain.Ticket;

import java.util.Date;

public interface TicketRepository extends BaseRepository<Ticket> {
    void deleteOldTicket(Date now);
}

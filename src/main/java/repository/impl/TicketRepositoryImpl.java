package repository.impl;

import base.BaseRepositoryImpl;
import domain.Ticket;
import repository.TicketRepository;

import java.util.Date;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket> implements TicketRepository {
    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    public void deleteOldTicket(Date now) {
        em.createQuery("delete from Ticket t where t.date <: date").setParameter("date", now).executeUpdate();
    }
}

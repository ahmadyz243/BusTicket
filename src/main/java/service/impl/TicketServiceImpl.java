package service.impl;

import base.BaseServiceImpl;
import domain.ComService;
import domain.Passenger;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;
import util.AppContext;

import java.util.Date;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public Ticket createTicketByServiceIdAndUserId(String serviceIdAndUserId) {
        ComService service = AppContext.comServiceService.findById(Integer.parseInt(serviceIdAndUserId.split("-")[0]));
        Passenger passenger = AppContext.passengerService.findById(Integer.parseInt(serviceIdAndUserId.split("-")[1]));
        Ticket ticket = new Ticket();
        ticket.setService(service);
        ticket.setDate(service.getDateAndTimeOfDeparture());
        ticket.setOrigin(service.getOriginCity());
        ticket.setDestination(service.getDestinationCity());
        ticket.setPassenger(passenger);
        save(ticket);
        beginTransAction();
        service.setEmptySeats(service.getEmptySeats() - 1);
        passenger.getTickets().add(ticket);
        commitTransaction();
        return ticket;
    }

    @Override
    public void deleteOldTickets() {
        beginTransAction();
        repository.deleteOldTicket(new Date());
        commitTransaction();
    }
}

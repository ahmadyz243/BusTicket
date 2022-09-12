package service;

import base.BaseService;
import domain.Ticket;

public interface TicketService extends BaseService<Ticket> {
    Ticket createTicketByServiceIdAndUserId(String serviceIdAndUserId);
    void deleteOldTickets();
}

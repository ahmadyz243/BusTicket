package util;

import repository.impl.ComServiceRepositoryImpl;
import repository.impl.CompanyRepositoryImpl;
import repository.impl.PassengerRepositoryImpl;
import repository.impl.TicketRepositoryImpl;
import service.ComServiceService;
import service.CompanyService;
import service.PassengerService;
import service.TicketService;
import service.impl.ComServiceServiceImpl;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TicketServiceImpl;

public class AppContext {
    public static CompanyService companyService= new CompanyServiceImpl(new CompanyRepositoryImpl());
    public static PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl());
    public static ComServiceService comServiceService = new ComServiceServiceImpl(new ComServiceRepositoryImpl());
    public static TicketService ticketService = new TicketServiceImpl(new TicketRepositoryImpl());
}

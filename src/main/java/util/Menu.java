package util;

import javassist.Loader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {

    static Scanner scanner;

    public static void printMainMenu() {
        System.out.println("1. login as company:");
        System.out.println("2. login as costumer:");
        System.out.println("3. signup as company:");
        System.out.println("4. signup as costumer:");
        System.out.println("5. exit:");
    }

    public static int numberScanner() {
        int number;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("you should enter number:");
            }
        }
        return number;
    }

    public static String stringScanner() {
        String string = "";
        while (string.isBlank() || string.isEmpty()) {
            scanner = new Scanner(System.in);
            string = scanner.next();
        }
        return string;
    }

    public static String lineScanner() {
        String string = "";
        while (string.isBlank() || string.isEmpty()) {
            scanner = new Scanner(System.in);
            string = scanner.nextLine();
        }
        return string;
    }

    public static void printEnterUserName() {
        System.out.println("enter userName:");
    }

    public static void printEnterPassWord() {
        System.out.println("enter password:");
    }

    public static void printEnterName() {
        System.out.println("please enter name:");
    }

    public static int selectAnOption(int numberOfOptions) {
        int selection = 0;
        while (selection < 1 || selection > numberOfOptions) {
            selection = numberScanner();
            if (selection < 1 || selection > numberOfOptions) System.out.println("wrong number! try again:");
        }
        return selection;
    }

    public static String createPassword() {
        String pass, passRepeat = "";
        System.out.println("enter new password:");
        pass = stringScanner();
        while (!Objects.equals(pass, passRepeat)) {
            System.out.println("repeat password:");
            passRepeat = Menu.stringScanner();
            if (!Objects.equals(pass, passRepeat)) {
                System.out.println("wrong repeat!");
            }
        }
        return pass;
    }


    public static void printEnterLastName() {
        System.out.println("please enter your lastname:");
    }

    public static void printUserNotFound() {
        System.out.println("user not found!");
    }

    public static void printWrongPassword() {
        System.out.println("wrong password!");
    }

    public static void printCompanyMenu() {
        System.out.println("1. add service:");
        System.out.println("2. back to main menu:");
    }

    public static void printEnterOriginCity() {
        System.out.println("enter origin city name:");
    }

    public static void printEnterDestinationCity() {
        System.out.println("enter destination city name:");
    }

    public static void printEnterPrice() {
        System.out.println("enter price:");
    }

    public static void printEnterDepartureDateAndTime() {
        System.out.println("enter departure date and time:");
    }

    public static Date getDateAndTimeFromUser() {
        String date, time;
        Date dAndT, now = new Date();
        while (true) {
            try {
                System.out.println("enter date: (like 1999/12/31)");
                date = Menu.stringScanner();
                System.out.println("enter time: (like 23:59)");
                time = Menu.stringScanner();
                dAndT = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(date + " " + time);
                if (dAndT.compareTo(now) < 0) {
                    System.out.println("you can't enter past time!");
                } else {
                    break;
                }
            } catch (ParseException p) {
                System.out.println("enter date and time carefully!");
            }
        }
        return dAndT;
    }

    public static void printEnterDateAndTimeOfReturn() {
        System.out.println("enter date and time of return:");
    }

    public static void printPassengerMenu() {
        System.out.println("1. view all services:");
        System.out.println("2. find service by origin and destination city:");
        System.out.println("3. back to main menu:");
    }

    public static void printViewServicesMenu() {
        System.out.println("1. sort by price:");
        System.out.println("2. sort by company:");
        System.out.println("3. sort by origin:");
        System.out.println("4. sort by destination:");
        System.out.println("5. back:");
    }

    public static Date dateAndTimeConvertor(String dateAndTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(dateAndTime.replace('T', ' '));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

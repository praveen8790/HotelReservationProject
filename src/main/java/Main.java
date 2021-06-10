import HotelReservation.contoller.Controller;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Controller controller =new Controller();
        /*
        consumertype = 1 -> regular
                       2 -> reward customer
        searchtype = 1-> cheapest
                     2-> cheapest and high rated
                     3-> high rated
        */
        System.out.println(controller.control(2,"10Sep2020","18Sep2020",1).toString());
    }
}

package HotelReservation.services;

import HotelReservation.entity.Hotel;
import HotelReservation.entity.Output;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class HotelServices {
    private static final long MILLIS_IN_A_DAY = 86400000;
    ArrayList<Hotel> hotel = new ArrayList<>();
    public HotelServices(Integer customertype) {
        hotel.add(new Hotel("Lakewood",3,110,90,80,80));
        hotel.add(new Hotel("Bridgewood",4,150,50,110,50));
        hotel.add(new Hotel("Ridgewood",5,200,150,100,40));
    }
    public Output findCheapestHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getCost));
        return result.get(0);
    }
    public Output findCheapestAndBestRatedHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getCost).thenComparing(Comparator.comparing(Output::getRating).reversed()));
        return result.get(0);
    }
    public Output findHighRatedHotel(ArrayList<Output> result){
        result.sort(Comparator.comparing(Output::getRating).reversed());
        return result.get(0);
    }



    public ArrayList<Output> searchAndCalculateCostForHotels(Integer customertype,ArrayList<Integer> datearray){
        ArrayList<Output> hotelcosts = new ArrayList<>();
         hotel.forEach(hotel1 -> {
             Output hotel = new Output(hotel1.getHotelname(),hotel1.getRating());
             AtomicReference<Integer> wholecost= new AtomicReference<>(0);
             datearray.forEach(day->{
                 switch (day) {
                     case 1 -> {//weekday
                             if(customertype ==1)
                                wholecost.set(wholecost.get() + hotel1.getRegularcustomer().getWeekday());
                             else
                                 wholecost.set(wholecost.get() + hotel1.getRewardcustomer().getWeekday());
                     }

                     case 2 -> {
                         if(customertype ==1)
                             wholecost.set(wholecost.get() + hotel1.getRegularcustomer().getWeekend());
                         else
                             wholecost.set(wholecost.get() + hotel1.getRewardcustomer().getWeekend());
                     }
                 }
             });
             hotel.setCost(wholecost.get());
            hotelcosts.add(hotel);
         });

        System.out.println(hotelcosts.toString());
         return hotelcosts;
    }
    public ArrayList<Integer> setDate(String sstartdate1, String senddate2) {
        SimpleDateFormat formatter=new SimpleDateFormat("ddMMMyyyy");
        Date date1 = null;
        try {
            date1 = formatter.parse(sstartdate1);
        } catch (ParseException e) {
            System.out.println("enter correct start date");
        }
        Date date2 = null;
        try {
            date2 = formatter.parse(senddate2);
        } catch (ParseException e) {
            System.out.println("enter correct end date");
        }
        ArrayList<Integer> day = new ArrayList<>();
        for(Date date = date1; Objects.requireNonNull(date2).compareTo(date)>=0; date=HotelServices.findNextDay(date))
            day.add(this.dayCalculator(date));
        return day;
    }

    private static Date findNextDay(Date date)
    {
        return new Date(date.getTime() + MILLIS_IN_A_DAY);
    }

    public Integer dayCalculator(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek=cal.get(Calendar.DAY_OF_WEEK);
        if(dayofweek != 1 && dayofweek != 7)
            return 1;
        else
            return 2;
    }
}

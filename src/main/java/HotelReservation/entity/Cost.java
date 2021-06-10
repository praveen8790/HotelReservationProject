package HotelReservation.entity;

public class Cost {
    Integer weekday;
    Integer weekend;

    public Cost(Integer weekday, Integer weekend) {
        this.weekday = weekday;
        this.weekend = weekend;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public Integer getWeekend() {
        return weekend;
    }
}

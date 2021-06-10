package HotelReservation.entity;

public class Hotel {
    private final String hotelname;
    private Integer rating;
    private Cost regularcustomer;
    private Cost rewardcustomer;

    public Cost getRegularcustomer() {
        return regularcustomer;
    }

    public void setRegularcustomer(Cost regularcustomer) {
        this.regularcustomer = regularcustomer;
    }

    public Cost getRewardcustomer() {
        return rewardcustomer;
    }

    public void setRewardcustomer(Cost rewardcustomer) {
        this.rewardcustomer = rewardcustomer;
    }

    public Hotel(String hotelname, Integer rating, Integer regularweekday, Integer regularweekend, Integer rewardweekday, Integer rewardweekend) {
        this.hotelname = hotelname;
        this.rating = rating;
        this.regularcustomer = new Cost(regularweekday,regularweekend);
        this.rewardcustomer = new Cost(rewardweekday,rewardweekend);
    }

    public String getHotelname() {
        return hotelname;
    }
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelname='" + hotelname + '\'' +
                ", rating=" + rating +
                ", regularcustomer=" + regularcustomer +
                ", rewardcustomer=" + rewardcustomer +
                '}';
    }
}

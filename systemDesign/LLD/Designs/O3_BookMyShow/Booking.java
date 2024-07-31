package systemDesign.LLD.Designs.O3_BookMyShow;

import java.lang.foreign.MemoryLayout.PathElement;
import java.util.List;

public class Booking {
    Show show;
    List<Seat> seats;
    PathElement payment;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public PathElement getPayment() {
        return payment;
    }

    public void setPayment(PathElement payment) {
        this.payment = payment;
    }
}

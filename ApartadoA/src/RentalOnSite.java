import java.time.*;

public class RentalOnSite extends Rental {
    private String comments;

    public RentalOnSite(LocalDateTime startDate, LocalDateTime endDate, Customer customer, Car car, RentalOffice pickUpOffice, String comments){
        super(startDate, endDate, car, customer, pickUpOffice);
        this.comments = comments;
    }

    //----------- getters ----------------
    private String getComments() {
        return this.comments;
    }

    //----------- setters ----------------
    private void setComments(String comments) {
        this.comments = comments;
    }

}
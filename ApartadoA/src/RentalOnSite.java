import java.time.*;

public class RentalOnSite extends Rental {
    private String comments;

    public RentalOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car, Customer customer, RentalOffice pickUpOffice, String comments){
        super(startDate, endDate, car, customer, pickUpOffice);
        this.comments = comments;
    }

//-------------------- GETTERS --------------------------

    private String getComments() {
        return this.comments;
    }

//-------------------- SETTERS --------------------------

    private void setComments(String comments) {
        this.comments = comments;
    }

}
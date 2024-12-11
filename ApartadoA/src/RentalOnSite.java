import java.time.LocalDate;

public class RentalOnSite extends Rental {
    private String comments;

    public RentalOnSite(LocalDate startDate, LocalDate endDate, Customer customer, Car car, RentalOffice pickUpOffice, String comments){
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
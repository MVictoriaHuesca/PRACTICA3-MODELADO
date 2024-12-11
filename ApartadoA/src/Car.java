import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;
    private RentalOffice assignedOffice;
    private List<Rental> rentals;

    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.assignedOffice = assignedOffice;
        this.rentals = new LinkedList<Rental>();
    }

    private String getLicensePlate() {
        return licensePlate;
    }

    private List<Rental> getRental(){
        return rentals;
    }

    private Model getModel() {
        return model;
    }

    public RentalOffice getAssignedOffice() { //es público porque accedemos a él en otra clase
        return assignedOffice;
    }

    private void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    private void setModel(Model model) {
        this.model = model;
    }

    private void setAssignedOffice(RentalOffice assignedOffice) {
        this.assignedOffice = assignedOffice;
    }

    private void setRentals(List<Rental> rentals){
        this.rentals = rentals;
    }

}
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
        System.out.println("El coche se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getLicensePlate() {
        return licensePlate;
    }

    public List<Rental> getRental(){
        return rentals;
    }

    private Model getModel() {
        return model;
    }

    protected RentalOffice getAssignedOffice() { //es público porque accedemos a él en otra clase
        return assignedOffice;
    }

//-------------------- SETTERS --------------------------

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
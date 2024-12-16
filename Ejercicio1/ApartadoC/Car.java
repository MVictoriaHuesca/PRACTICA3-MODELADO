import java.time.*;
import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;
    private RentalOffice assignedOffice;
    private List<Rental> rentals;

    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        assert(licensePlate != null && model != null && assignedOffice != null);
        this.licensePlate = licensePlate;
        this.model = model;
        model.addCar(this);
        this.assignedOffice = assignedOffice;        
        this.rentals = new LinkedList<Rental>();
        this.assignedOffice.addCar(this);
        System.out.println("El coche con matrícula " + licensePlate + " se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getLicensePlate() {
        return licensePlate;
    }

    protected Enumeration<Rental> getRental(){
        return Collections.enumeration(rentals);
    }

    private Model getModel() {
        return model;
    }
    
    protected RentalOffice getAssignedOffice() { //es protegido porque accedemos a él en otra clase
        return assignedOffice;
    }

//-------------------- SETTERS --------------------------
    
    private void setLicensePlate(String licensePlate) {
        assert(licensePlate != null);
        this.licensePlate = licensePlate;
    }

    private void setModel(Model model) {
        assert(model != null);
        this.model = model;
    }

    private void setAssignedOffice(RentalOffice assignedOffice) {
        assert(assignedOffice != null);
        this.assignedOffice = assignedOffice;
    }

    protected void addRental(Rental rental){
        assert(rental != null);
        this.rentals.add(rental);
    }

    private void removeRental(Rental rental){
        assert(rental != null);
        this.rentals.remove(rental);
    }
}
package Ejercicio3.ApartadoC;
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
        model.getCars().add(this);
        this.assignedOffice = assignedOffice;        
        this.rentals = new LinkedList<Rental>();
        this.assignedOffice.getCars().add(this);
        System.out.println("El coche con matrícula " + licensePlate + " se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getLicensePlate() {
        return licensePlate;
    }

    protected List<Rental> getRental(){
        return rentals;
    }

    protected Model getModel() {
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

    private void setRentals(List<Rental> rentals){
        assert(rentals != null);
        this.rentals = rentals;
    }
}
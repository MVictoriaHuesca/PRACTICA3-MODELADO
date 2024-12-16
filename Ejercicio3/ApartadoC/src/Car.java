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

    protected Enumeration<Rental> getRentals(){
        return Collections.enumeration(rentals);
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
        if(this.model != null) {
            this.model.removeCar(this);
        }
        this.model = model;
        model.addCar(this);
    }

    private void setAssignedOffice(RentalOffice assignedOffice) {
        assert(assignedOffice != null);
        if(this.assignedOffice != null) {
            this.assignedOffice.removeCar(this);
        }
        this.assignedOffice = assignedOffice;
        assignedOffice.addCar(this);
    }

    protected void addRental(Rental rental){
        assert(rental != null);
        this.rentals.add(rental);
    }

    protected void removeRental(Rental rental){
        assert(rental != null);
        this.rentals.remove(rental);
    }
}
import java.time.LocalDate;
import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;
    private RentalOffice assignedOffice;
    private List<Rental> rentals;
    private ICarState state;

    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.assignedOffice = assignedOffice;
        this.rentals = new LinkedList<Rental>();
        this.state = new InServiceState();
        System.out.println("El coche se ha creado correctamente");
    }

    private String getLicensePlate() {
        return licensePlate;
    }

    public List<Rental> getRental(){
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

    public void setState(ICarState state) {
        this.state = state;
    }

    public ICarState getState() {
        return state;
    }

    //-----------metodos----------------

    public void takeOutOfService(LocalDate backToServiceDate) {
        if (state == null) {
            throw new IllegalStateException("El estado del coche no está inicializado.");
        }
        state.takeOutOfService(this, backToServiceDate);
    }
}
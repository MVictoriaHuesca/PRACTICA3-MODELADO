import java.time.*;
import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;
    private RentalOffice assignedOffice;
    private List<Rental> rentals;
    private CarState state;

    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.assignedOffice = assignedOffice;        
        this.rentals = new LinkedList<Rental>();
        this.assignedOffice.getCars().add(this);
        this.state = new InServiceState(this);
        System.out.println("El coche se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getLicensePlate() {
        return licensePlate;
    }

    protected List<Rental> getRental(){
        return rentals;
    }

    private Model getModel() {
        return model;
    }

    private CarState getState() {
        return state;
    }
    
    protected RentalOffice getAssignedOffice() { //es protegido porque accedemos a él en otra clase
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

    private void setState(CarState state) {
        this.state = state;
    }

//-------------------- OTHER METHODS --------------------------

    public void takeOutOfService(LocalDateTime backToServiceDate) {
        if (this.getState() instanceof OutOfServiceState || this.getState() instanceof IsSubstitute) {
            System.out.println("El coche ya está fuera de servicio o es un coche sustituto");
        } else {
            this.setState(new OutOfServiceState(this, backToServiceDate));
            List<Car> cars = this.assignedOffice.getCars();
            Car substitute = null;
            for(Car car : cars){
                if(car.getModel().equals(this.getModel()) && car.getState() instanceof InServiceState && car != this){
                    substitute = car;
                    substitute.setState(new IsSubstitute(substitute));
                    break;
                }
            }
            
            System.out.println("El coche se ha puesto fuera de servicio correctamente, fecha de vuelta al servicio: " + backToServiceDate);
            
            if(substitute != null) {
                System.out.println("El coche sustituto es: " + substitute.getLicensePlate());
            } else {
                System.out.println("No hay coches sustitutos disponibles");
            }
        }
    }
}
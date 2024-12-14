package src;
import java.time.*;
import java.util.*;

public class Car {
    private String licensePlate;
    
    private Model model;
    private RentalOffice assignedOffice;
    private List<Rental> rentals;
    private CarState state;

    public Car(String licensePlate, Model model, RentalOffice assignedOffice) {
        assert(licensePlate != null && model != null && assignedOffice != null);
        this.licensePlate = licensePlate;
        this.model = model;
        model.getCars().add(this);
        this.assignedOffice = assignedOffice;        
        this.rentals = new LinkedList<Rental>();
        this.assignedOffice.getCars().add(this);
        this.state = new InServiceState(this);
        System.out.println("El coche con matrícula " + licensePlate + " se ha creado correctamente");
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

    protected CarState getState() {
        return state;
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

    private void setState(CarState state) {
        assert(state != null);
        this.state = state;
    }

//-------------------- OTHER METHODS --------------------------

    /**
        Esta funcionalidad pondrá el coche fuera de
        servicio y registrará la fecha hasta la cual estará fuera de servicio y, si hay, buscará y registrará también un coche
        sustituto
     */
    public void takeOutOfService(LocalDateTime backToServiceDate) {
        assert(backToServiceDate != null);
        if (this.getState() instanceof OutOfServiceState || this.getState() instanceof IsSubstituteState) {
            System.out.println("El coche ya está fuera de servicio o es un coche sustituto");
        } else {
            this.setState(new OutOfServiceState(this, backToServiceDate));
            List<Car> cars = this.assignedOffice.getCars();
            Car substitute = null;
            for(Car car : cars){
                if(car.getModel().equals(this.getModel()) && car.getState() instanceof InServiceState && car != this){
                    substitute = car;
                    substitute.setState(new IsSubstituteState(substitute));
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
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
        model.addCar(this);
        this.assignedOffice = assignedOffice;        
        this.rentals = new LinkedList<Rental>();
        this.assignedOffice.addCar(this);
        this.state = new InServiceState(this);
        System.out.println("El coche con matrícula " + licensePlate + " se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getLicensePlate() {
        return licensePlate;
    }

    protected Enumeration<Rental> getRentals(){
        return Collections.enumeration(rentals);
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
            Enumeration<Car> listaCochesOficina = this.assignedOffice.getCars();
            List<Car> cars = new ArrayList<>();
            while(listaCochesOficina.hasMoreElements()){
                cars.add(listaCochesOficina.nextElement());
            }
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
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Car car;
    private Customer customer;
    private RentalOffice pickUpOffice;

    public Rental(LocalDateTime sDate, LocalDateTime eDate, Car c, Customer customer, RentalOffice pickUpOffice) {
        assert(sDate != null && eDate != null && car != null && customer != null && pickUpOffice != null); 
        assert(noAlquileresSolapados(customer, sDate) && sDate.isBefore(eDate) && noOficinasDistintas(car, pickUpOffice)); // Se comprueban las restricciones de integridad 1, 2 y 3
        this.car = c;
        this.startDate = sDate;
        this.endDate = eDate;
        this.customer = customer;
        this.pickUpOffice = pickUpOffice;
    }

//-------------------- GETTERS --------------------------
    
    private LocalDateTime getStartDate() {
        return this.startDate;
    }

    private LocalDateTime getEndDate() {
        return this.endDate;
    }
    
    private Car getCar() {
        return this.car;
    }

    private Customer getCustomer() {
        return this.customer;
    }

    protected RentalOffice getpickUpOffice() {
        return this.pickUpOffice;
    }
    
//-------------------- SETTERS --------------------------


    private void setStartDate(LocalDateTime startDate) {
        assert(startDate != null);
        this.startDate = startDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        assert(endDate != null);
        this.endDate = endDate;
    }

    private void setCar(Car car) {
        assert(car != null);
        this.car = car;
    }

    private void setCustomer(Customer customer) {
        assert(customer != null);
        this.customer = customer;
    }

    private void setpickUpOffice(RentalOffice pickUpOffice) {
        assert(pickUpOffice != null);
        this.pickUpOffice = pickUpOffice;
    }

//-------------------- OTHER METHODS --------------------------
    
    /**
     * Comprueba que un cliente no tenga alquileres solapados
     */
    private boolean noAlquileresSolapados(Customer customer, LocalDateTime startDate) { 
        boolean sol = true;
        List<Rental> allRentals = new ArrayList<>(customer.getRentalsOnSite());
        allRentals.addAll(customer.getWebRentals());
        for(Rental rental: allRentals) {
            if(rental.getEndDate().isAfter(startDate)){
                sol = false;
            }
        }
        return sol;
    }
    
    /**
     * Comprueba que la oficina asignada al coche es la misma que la de pickup
     */
    private boolean noOficinasDistintas(Car car, RentalOffice pickUpOffice) { 
        assert(car != null && pickUpOffice != null);
        return car.getAssignedOffice().equals(pickUpOffice);
    }    
}



import java.time.*;

public class Rental {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Car car;
    private Customer customer;
    private RentalOffice pickUpOffice;

    public Rental(LocalDateTime sDate, LocalDateTime eDate, Car c, Customer customer, RentalOffice pickUpOffice) {
        assert(noAlquileresSolapados(customer, sDate) && sDate.isBefore(eDate) && noOficinasDistintas(car, pickUpOffice)); // Se comprueban las restricciones de integridad 1, 2 y 3
        this.car = c;
        this.startDate = sDate;
        this.endDate = eDate;
        this.customer = customer;
        this.pickUpOffice = pickUpOffice;
    }

    //------------- getters ----------------
    
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

    private RentalOffice getpickUpOffice() {
        return this.pickUpOffice;
    }
    
    //------------- setters ----------------


    private void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    private void setCar(Car car) {
        this.car = car;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private void setpickUpOffice(RentalOffice pickUpOffice) {
        this.pickUpOffice = pickUpOffice;
    }

    //------------- other methods ----------------

    private boolean noAlquileresSolapados(Customer customer, LocalDateTime startDate) { // Comprueba que un cliente no tenga alquileres solapados
        boolean sol = true;
        for(Rental rental: customer.getRentals()) {
            if(rental.getEndDate().isAfter(startDate)){
                sol = false;
            }
        }
        return sol;
    }

    private boolean noOficinasDistintas(Car car, RentalOffice pickUpOffice) { // Comprueba que la oficina asignada al coche es la misma que la de pickup
        return car.getAssignedOffice().equals(pickUpOffice);
    }    
}



import java.time.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class Rental {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Car car;
    private Customer customer;
    private RentalOffice pickUpOffice;
    private IPromotionStrategy promotion;

    public Rental(LocalDateTime sDate, LocalDateTime eDate, Car c, Customer customer, RentalOffice pickUpOffice, IPromotionStrategy promotion) {
        // no hace falta comprobar que promotion no sea null ya que podría no aplicarse ninguna promoción
        assert(sDate != null && eDate != null && car != null && customer != null && pickUpOffice != null);
        assert(noAlquileresSolapados(customer, sDate) && sDate.isBefore(eDate) && noOficinasDistintas(car, pickUpOffice)); // Se comprueban las restricciones de integridad 1, 2 y 3
        this.car = c;
        c.addRental(this);
        this.startDate = sDate;
        this.endDate = eDate;
        this.customer = customer;
        customer.addRental(this);
        this.pickUpOffice = pickUpOffice;
        pickUpOffice.addRental(this);
        this.promotion = promotion;
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

    private IPromotionStrategy getPromotion() {
        return this.promotion;
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
        if(this.car != null) {
            this.car.removeRental(this);
        }
        this.car = car;
        car.addRental(this);
    }

    private void setCustomer(Customer customer) {
        assert(customer != null);
        if(this.customer != null) {
            this.customer.removeRental(this);
        }
        this.customer = customer;
        customer.addRental(this);        
    }

    private void setpickUpOffice(RentalOffice pickUpOffice) {
        assert(pickUpOffice != null);
        if(this.pickUpOffice != null) {
            this.pickUpOffice.removeRental(this);
        }
        this.pickUpOffice = pickUpOffice;
        pickUpOffice.addRental(this);
    }

    protected void setPromotion(IPromotionStrategy promotion) {
        this.promotion = promotion;
    }


//-------------------- OTHER METHODS --------------------------
   
    /**
     * Comprueba que un cliente no tenga alquileres solapados
     */
    private boolean noAlquileresSolapados(Customer customer, LocalDateTime startDate) { // REVISAR
        boolean sol = true;
        List<Rental> allRentals = new ArrayList<>(); 
        Enumeration<Rental> listaRentals = customer.getRentals();
        //añadir todos los rentals del enumeration en la lista 
        while (listaRentals.hasMoreElements()) {
            allRentals.add(listaRentals.nextElement());
        }        
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


    /**
     * Proporciona el precio del alquiler del coche
     */
    protected double getPrice(){
        int days = (int) Duration.between(startDate, endDate).toDays();
        double basePrice = car.getModel().getpricePerDay() * days;
        if (promotion != null) {
            return promotion.applyPromotion(basePrice);
        }
        return basePrice;
    }
}




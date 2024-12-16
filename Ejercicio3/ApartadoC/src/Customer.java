import java.util.*;
import java.time.*;

public class Customer{
    private String dni;
    private String name;
    
    private List<Rental> rentals;

    public Customer (String dni, String name) {
        assert(dni != null && name != null);
        this.dni = dni;
        this.name = name;
        this.rentals = new LinkedList<>();
        System.out.println("El cliente " + name + " se ha registrado correctamente");
    }

//-------------------- GETTERS --------------------------
    
    private String getDni(){
        return this.dni;
    }

    protected String getName(){
        return this.name;
    }
    
    protected Enumeration<Rental> getRentals() {
        return Collections.enumeration(this.rentals);
    }

    private List<WebRental> getWebRentals(){
        List<WebRental> webRentals = new LinkedList<>();
        for(Rental rental : rentals){
            if(rental instanceof WebRental){
                webRentals.add((WebRental) rental);
            }
        }
        return webRentals;
    }
    
//-------------------- SETTERS --------------------------
    
    private void setName(String name) {
        assert(name != null);
        this.name = name;
    }

    private void setDni(String dni) {
        assert(dni != null);
        this.dni = dni;
    }
    
    protected void addRental (Rental rental) {
        assert(rental != null);
        this.rentals.add(rental);
    }

    protected void removeRental (Rental rental) {
        assert(rental != null);
        this.rentals.remove(rental);
    }
        

//-------------------- OTHER METHODS --------------------------

    /**
     * Permite alquilar un coche en una oficina de alquiler
     */
    public void rentCarOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, IPromotionStrategy promotion, String comment){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && comment != null);
        RentalOnSite rental = new RentalOnSite(startDate, endDate, car, this, pickUpOffice, promotion, comment);
        System.out.println(this.name + " ha añadido un nuevo alquiler en oficina. Total alquileres de este cliente: " + (this.rentals.size()));
    }
    
    /**
     * Permite alquilar un coche a través de la web
     */
    public void rentCarOnWeb(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice,IPromotionStrategy promotion, RentalOffice deliveryoffice){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && deliveryoffice != null);
        WebRental rental = new WebRental(startDate, endDate, car, this, pickUpOffice, promotion, deliveryoffice);
        System.out.println(this.name + " ha añadido un nuevo alquiler por web. Total alquileres de este cliente: " + (this.rentals.size()));
    }
}

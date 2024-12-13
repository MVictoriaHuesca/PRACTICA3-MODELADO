import java.util.*;
import java.time.*;

public class Customer{
    private String dni;
    private String name;
    
    private List<RentalOnSite> rentalsOnSite;
    private List<WebRental> webRentals;

    public Customer (String dni, String name) {
        assert(dni != null && name != null);
        this.dni = dni;
        this.name = name;
        this.rentalsOnSite = new LinkedList<>();
        this.webRentals = new LinkedList<>();
        System.out.println("El cliente " + name + " se ha registrado correctamente");
    }

    //--------------- getters --------------------
    
    private String getDni(){
        return this.dni;
    }

    protected String getName(){
        return this.name;
    }
    
    public List<RentalOnSite> getRentalsOnSite() {
        return this.rentalsOnSite;
    }

    protected List<WebRental> getWebRentals() {
        return this.webRentals;
    }
    
    //--------------- setters ---------------------
    
    private void setName(String name) {
        assert(name != null);
        this.name = name;
    }

    private void setDni(String dni) {
        assert(dni != null);
        this.dni = dni;
    }
    
    private void setRentalsOnSite (List<RentalOnSite> rentalsOnSite) {
        assert(rentalsOnSite != null);
        this.rentalsOnSite = rentalsOnSite;
    }
    
    private void setWebRentals (List<WebRental> webRentals) {
        assert(webRentals != null);
        this.webRentals = webRentals;
    }

    
    public void rentCarOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, String comment){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && comment != null);
        RentalOnSite rental = new RentalOnSite(startDate, endDate, car, this, pickUpOffice, comment);
        rentalsOnSite.add(rental);
        pickUpOffice.getRental().add(rental);
        car.getRental().add(rental);
        System.out.println("Se ha añadido un nuevo alquiler en oficina. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }

    public void rentCarOnWeb(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, RentalOffice deliveryoffice){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && deliveryoffice != null);
        WebRental rental = new WebRental(startDate, endDate, car, this, pickUpOffice, deliveryoffice);
        pickUpOffice.getRental().add(rental);
        deliveryoffice.getWebRentals().add(rental);
        webRentals.add(rental);
        car.getRental().add(rental);
        System.out.println("Se ha añadido un nuevo alquiler por web. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }
}

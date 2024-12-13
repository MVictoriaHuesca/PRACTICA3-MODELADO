import java.util.*;
import java.time.*;

public class Customer{
    private String dni;
    private String name;
    
    private List<RentalOnSite> rentalsOnSite;
    private List<WebRental> webRentals;

    public Customer (String dni, String name) {
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
        this.name = name;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }
    
    private void setRentalsOnSite (List<RentalOnSite> rentalsOnSite) {
        this.rentalsOnSite = rentalsOnSite;
    }
    
    private void setWebRentals (List<WebRental> webRentals) {
        this.webRentals = webRentals;
    }

    
    public void rentCarOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, String comment){
        RentalOnSite rental = new RentalOnSite(startDate, endDate, car, this, pickUpOffice, comment);
        pickUpOffice.getRental().add(rental);
        rentalsOnSite.add(rental);
        car.getRental().add(rental);
        System.out.println("Se ha añadido un nuevo alquiler en oficina. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }

    public void rentCarOnWeb(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, RentalOffice deliveryoffice){
        WebRental rental = new WebRental(startDate, endDate, car, this, pickUpOffice, deliveryoffice);
        pickUpOffice.getRental().add(rental);
        deliveryoffice.getWebRentals().add(rental);
        webRentals.add(rental);
        car.getRental().add(rental);
        System.out.println("Se ha añadido un nuevo alquiler por web. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }
}

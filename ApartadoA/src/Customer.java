import java.util.*;
import java.time.*;

public class Customer implements ICustomer<WebRental> {
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

//-------------------- GETTERS --------------------------
    
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
    
//-------------------- SETTERS --------------------------
    
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

//-------------------- OTHER METHODS --------------------------

    /**
     * Permite alquilar un coche en una oficina de alquiler
     */
    public void rentCarOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, String comment){
        RentalOnSite rental = new RentalOnSite(startDate, endDate, car, this, pickUpOffice, comment);
        rentalsOnSite.add(rental);
        car.getRental().add(rental);
        System.out.println(this.name + " ha añadido un nuevo alquiler en oficina. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }
    
    /**
     * Permite alquilar un coche a través de la web
     */
    public void rentCarOnWeb(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, RentalOffice deliveryoffice){
        WebRental rental = new WebRental(startDate, endDate, car, this, pickUpOffice, deliveryoffice);
        webRentals.add(rental);
        car.getRental().add(rental);
        System.out.println(this.name + " ha añadido un nuevo alquiler por web. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }

    /**
     * Devuelve el número de alquileres web de un cliente en los que difieren la oficina de entrega y devolución del coche
     */
    public Integer numberOfRentalsWithDifferentOffices() {
        int count = 0;
        Iterator<WebRental> iterator = createWebRentalIterator();
        while (iterator.hasNext()) {
            WebRental rental = iterator.next();
            if (!rental.getpickUpOffice().equals(rental.getDeliveryOffice())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Iterator<WebRental> createWebRentalIterator() {
        return new WebRentalIterator(webRentals);
    }
}

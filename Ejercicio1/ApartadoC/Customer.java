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
    
    private Enumeration<RentalOnSite> getRentalsOnSite() {
        return Collections.enumeration(this.rentalsOnSite);
    }

    protected Enumeration<WebRental> getWebRentals() {
        return Collections.enumeration(this.webRentals);
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
    
    protected void addRentalOnSite (RentalOnSite rental) {
        assert(rental != null);
        this.rentalsOnSite.add(rental);
    }

    protected void removeRentalOnSite (RentalOnSite rental) {
        assert(rental != null);
        this.rentalsOnSite.remove(rental);
    }
    
    protected void addWebRental (WebRental rental) {
        assert(rental != null);
        this.webRentals.add(rental);
    }

    protected void removeWebRental (WebRental rental) {
        assert(rental != null);
        this.webRentals.remove(rental);
    }

//-------------------- OTHER METHODS --------------------------

    /**
     * Permite alquilar un coche en una oficina de alquiler
     */
    public void rentCarOnSite(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, String comment){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && comment != null);
        RentalOnSite rental = new RentalOnSite(startDate, endDate, car, this, pickUpOffice, comment);
        rentalsOnSite.add(rental);
        car.addRental(rental);
        pickUpOffice.addRental(rental);
        System.out.println(this.name + " ha añadido un nuevo alquiler en oficina. Total alquileres de este cliente: " + (rentalsOnSite.size() + webRentals.size()));
    }
    
    /**
     * Permite alquilar un coche a través de la web
     */
    public void rentCarOnWeb(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice, RentalOffice deliveryoffice){
        assert(startDate != null && endDate != null && car != null && pickUpOffice != null && deliveryoffice != null);
        WebRental rental = new WebRental(startDate, endDate, car, this, pickUpOffice, deliveryoffice);
        webRentals.add(rental);
        car.addRental(rental);
        pickUpOffice.addRental(rental);
        deliveryoffice.addWebRental(rental);
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

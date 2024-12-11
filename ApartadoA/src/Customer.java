import java.util.*;
import java.time.*;


public class Customer implements ICustomer{
    private String dni;
    private String name;
    
    private List<Rental> rentals;

    public Customer (String dni, String name) {
        this.dni = dni;
        this.name = name;
        this.rentals = new LinkedList<>();
    }

    //--------------- getters --------------------
    
    private String getDni(){
        return this.dni;
    }

    private String getName(){
        return this.name;
    }
    
    public List<Rental> getRentals() {
        return this.rentals;
    }
    
    //--------------- setters ---------------------
    
    private void setName(String name) {
        this.name = name;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }
    
    private void setRentals (List<Rental> rentals){
        this.rentals = rentals;
    }
    


    public void alquilarCoche(LocalDateTime startDate, LocalDateTime endDate, Car car,RentalOffice pickUpOffice){
        Rental nuevoRental = new Rental(startDate, endDate, car, this, pickUpOffice);
        rentals.add(nuevoRental);
        System.out.println("Se ha añadido un nuevo alquiler. Total alquileres de este customer: " + rentals.size());
    }

    @Override
    //IMPLEMENTAR
    public WebRentalIterator createWebRentalIterator(){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWebRentalIterator'");
    }
}

import java.util.*;

public class RentalOffice {
    private String address;
    private Integer feeForDelivery;

    private List<Car> cars;
    private List<Rental> rentals;
    private List<WebRental> webRentals;

    public RentalOffice(String address, Integer feeForDelivery) {
        assert(address != null && feeForDelivery != null);
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.rentals = new LinkedList<Rental>();
        this.cars = new LinkedList<Car>();
        this.webRentals = new LinkedList<WebRental>();
        System.out.println("La oficina situada en " + address + " se ha creado correctamente");
    }

//-------------------- GETTERS --------------------------

    private String getAddress() {
        return address;
    }

    private Integer getFeeForDelivery(){
        return feeForDelivery;
    }

    protected Enumeration<Rental> getRental(){
        return Collections.enumeration(rentals);
    }

    protected Enumeration<Car> getCars(){
        return Collections.enumeration(cars);
    }

    protected Enumeration<WebRental> getWebRentals(){
        return Collections.enumeration(webRentals);
    }

//-------------------- SETTERS --------------------------

    private void setAddress(String address) {
        assert(address != null);
        this.address = address;
    }

    private void setfeeForDelivery(Integer feeForDelivery) {
        assert(feeForDelivery != null);
        this.feeForDelivery = feeForDelivery;
    }

    protected void addRental(Rental rental){
        assert(rentals != null);
        this.rentals.add(rental);
    }

    private void removeRental(Rental rental){
        assert(rentals != null);
        this.rentals.remove(rental);
    }

    protected void addCar(Car car){
        assert(cars != null);
        this.cars.add(car);
    }

    private void removeCar(Car car){
        assert(cars != null);
        this.cars.remove(car);
    }

    protected void addWebRental(WebRental webRentals){
        assert(webRentals != null);
        this.webRentals.add(webRentals);
    }

    private void removeWebRental(WebRental webRentals){
        assert(webRentals != null);
        this.webRentals.remove(webRentals);
    }

}

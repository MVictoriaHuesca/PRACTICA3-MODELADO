import java.time.*;

public class WebRental extends Rental{
    private Integer deliveryTime;

    private RentalOffice deliveryOffice;
    
    public WebRental(LocalDateTime startDate, LocalDateTime endDate, Car car, Customer customer, RentalOffice pickUpOffice, RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);
        assert(deliveryOffice != null && comprobarHoraOficinasDiferentes(pickUpOffice, deliveryOffice, endDate));
        this.deliveryTime = 0;
        this.deliveryOffice = deliveryOffice;
        deliveryOffice.addWebRental(this);
    }

 //-------------------- GETTERS --------------------------

    private Integer getDeliveryTime(){
        return deliveryTime;
    }

    protected RentalOffice getDeliveryOffice(){
        return deliveryOffice;
    }

//-------------------- SETTERS --------------------------

    private void setDeliveryTime(Integer deliveryTime){
        assert(deliveryTime != null);
        this.deliveryTime = deliveryTime;
    }

    private void setDeliveryOffice(RentalOffice deliveryOffice){
        assert(deliveryOffice != null);
        if(this.deliveryOffice != null) {
            this.deliveryOffice.removeWebRental(this);
        }
        this.deliveryOffice = deliveryOffice;
        deliveryOffice.addRental(this);
    }

//-------------------- OTHER METHODS --------------------------

    /**
     * Devuelve true si, cuando las oficinas de recogida/entrega son diferentes, la hora es anterior a las 13h
     */
    private boolean comprobarHoraOficinasDiferentes(RentalOffice pickupOffice, RentalOffice deliveryOffice, LocalDateTime endDate){ 
        boolean sol = true;
        if(pickupOffice != deliveryOffice){
            if(endDate.getHour() > 13) {
                sol = false;
            }
        }
        return sol;
    }
}


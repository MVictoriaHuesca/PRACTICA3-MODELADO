import java.time.*;

public class WebRental extends Rental{
    private Integer deliveryTime;   // Este atributo puede estar a null, representa la hora a la que se devuelve el coche

    private RentalOffice deliveryOffice;
    
    public WebRental(LocalDateTime startDate, LocalDateTime endDate, Car car, Customer customer, RentalOffice pickUpOffice, RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);
        assert(comprobarHoraOficinasDiferentes(pickUpOffice, deliveryOffice, endDate));
        this.deliveryTime = 0;
        this.deliveryOffice = deliveryOffice;
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
        this.deliveryTime = deliveryTime;
    }

    private void setRentalOffice(RentalOffice deliveryOffice){
        this.deliveryOffice = deliveryOffice;
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


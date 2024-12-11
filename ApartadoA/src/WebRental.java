import java.time.*;

public class WebRental extends Rental{
    private Integer deliveryTime;   // 0..1 (cuando sea 0 Integer será null)

    private RentalOffice deliveryOffice;
    
    public WebRental(LocalDateTime startDate, LocalDateTime endDate, Car car, Customer customer, RentalOffice pickUpOffice, RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);
        assert(comprobarHoraOficinasDiferentes(pickUpOffice, deliveryOffice, endDate));
        this.deliveryTime = 0;
        this.deliveryOffice = deliveryOffice;
    }

    //------------------------------------GETTERS AND SETTERS------------------------------------

    private Integer getDeliveryTime(){
        return deliveryTime;
    }

    private RentalOffice getDeliveryOffice(){
        return deliveryOffice;
    }

    private void setDeliveryTime(Integer deliveryTime){
        this.deliveryTime = deliveryTime;
    }

    private void setRentalOffice(RentalOffice deliveryOffice){
        this.deliveryOffice = deliveryOffice;
    }

    //----------------- other methods -------------------

    // Devuelve true si, cuando las oficinas de recogida/entrega son diferentes, la hora es anterior a las 13h
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


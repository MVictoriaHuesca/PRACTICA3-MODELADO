import java.time.LocalDate;

public class WebRental extends Rental{
    private Integer deliveryTime;   // 0..1 (cuando sea 0 Integer será null)

    private RentalOffice deliveryOffice;
    
    public WebRental(LocalDate startDate, LocalDate endDate, Car car, Customer customer, RentalOffice pickUpOffice, RentalOffice deliveryOffice) {
        super(startDate, endDate, car, customer, pickUpOffice);
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

    // COMPROBAR LA RESTRICCIÓN DE INTEGRIDAD Nº4
}


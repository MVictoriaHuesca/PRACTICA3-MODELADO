import java.time.*;

class InServiceState implements  ICarState {
    @Override
    public void takeOutOfService(Car car, LocalDate backToServiceDate) {
        System.out.println("Poniendo el coche fuera de servicio.");
        car.setState(new OutOfServiceState(backToServiceDate));
    }
}
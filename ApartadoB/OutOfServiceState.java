import java.time.*;


class OutOfServiceState implements ICarState {
    private LocalDate backToServiceDate;
    private Car substituteCar;

    public OutOfServiceState(LocalDate backToServiceDate) {
        this.backToServiceDate = backToServiceDate;
    }

    public void setSubstituteCar(Car substituteCar) {
        this.substituteCar = substituteCar;
    }

    @Override
    public void takeOutOfService(Car car, LocalDate backToServiceDate) {
        System.out.println("El coche ya está fuera de servicio.");
    }
}
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Customer Customer1 = new Customer("77515974W", "Pepe");
        Customer Customer2 = new Customer("89562356T", "Sara");

        LocalDateTime fecha1 = LocalDateTime.of(LocalDate.of(2020,12,20), LocalTime.of(12,53));
        LocalDateTime fecha2 = LocalDateTime.of(LocalDate.of(2021,2,12), LocalTime.of(8,35));

        Model ferrari = new Model("Ferrari", 50);

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);
        RentalOffice oficina2 = new RentalOffice("Calle Larios, 3", 25);

        Car coche = new Car("2587MDN", ferrari, oficina1);

        Customer1.rentCarOnWeb(fecha1, fecha2, coche, oficina1, oficina1);
        
    }
}
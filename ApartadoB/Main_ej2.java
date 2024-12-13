import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main_ej2 {
    public static void main(String[] args) {
        Customer Customer1 = new Customer("77515974W", "Pepe");
        Customer Customer2 = new Customer("89562356T", "Sara");

        LocalDateTime fecha1 = LocalDateTime.of(LocalDate.of(2020,12,20), LocalTime.of(12,53));
        LocalDateTime fecha2 = LocalDateTime.of(LocalDate.of(2021,2,12), LocalTime.of(8,35));
        LocalDateTime fecha3 = LocalDateTime.of(LocalDate.of(2021,4,21), LocalTime.of(10,11));
        LocalDateTime fecha4 = LocalDateTime.of(LocalDate.of(2021,7,18), LocalTime.of(22,37));
        LocalDateTime fecha5 = LocalDateTime.of(LocalDate.of(2021,9,27), LocalTime.of(18,47));
        LocalDateTime fecha6 = LocalDateTime.of(LocalDate.of(2021,12,8), LocalTime.of(10,28));


        Model ferrari = new Model("Ferrari", 50);

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);
        RentalOffice oficina2 = new RentalOffice("Calle Larios, 3", 25);

        Car coche1 = new Car("2587MDN", ferrari, oficina1);
        Car coche2 = new Car("7856BPM", ferrari, oficina1);

        coche1.takeOutOfService(fecha6);
        System.out.println("Coches en la oficina1: " + oficina1.getCars());
    }
}


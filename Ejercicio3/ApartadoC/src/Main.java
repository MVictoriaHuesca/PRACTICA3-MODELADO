import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Enumeration;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        PercentagePromotion percentagePromotion = new PercentagePromotion(10);
        AmountPromotion amountPromotion = new AmountPromotion(5);

        Customer Customer1 = new Customer("77515974M", "Francisco");
        Customer Customer2 = new Customer("77515974F", "Marcos");
        Customer Customer3 = new Customer("77515974M", "Soraya");
        Customer Customer4 = new Customer("77515974V", "Victoria");

        LocalDateTime fecha1 = LocalDateTime.of(LocalDate.of(2020,12,20), LocalTime.of(8,00));
        LocalDateTime fecha2 = LocalDateTime.of(LocalDate.of(2020,12,22), LocalTime.of(8,00));


        Model ferrari = new Model("Ferrari", 100.00);

        RentalOffice oficina1 = new RentalOffice("Av. Plutarco, 75", 20);
        RentalOffice oficina2 = new RentalOffice("Calle Larios, 3", 25);

        Car coche1 = new Car("2587MDN", ferrari, oficina1);
        Car coche2 = new Car("7856BPM", ferrari, oficina1);
        Car coche3 = new Car("7856BPZ", ferrari, oficina1);
        Car coche4 = new Car("7856BPU", ferrari, oficina1);

        System.out.println("\nEl precio del modelo ferrari por día es: " + ferrari.getpricePerDay() + "\n");

        // CASO 1: alquiler de coche con descuento porcentaje
        Customer1.rentCarOnSite(fecha1, fecha2, coche1, oficina1, percentagePromotion, "Alquiler de coche con descuento por porcentaje");
        Enumeration<Rental> listaRentals1 = Customer1.getRentals();
        Rental ultimoRental1 = null;
        while (listaRentals1.hasMoreElements()){
            ultimoRental1 = listaRentals1.nextElement();
        }
        double price1 = ultimoRental1.getPrice();
        System.out.println("El precio del alquiler con descuento por porcentaje es: " + price1 + "\n");


        // CASO 2: alquiler de coche con descuento cantidad
        Customer2.rentCarOnSite(fecha1, fecha2, coche2, oficina1, amountPromotion, "Alquiler de coche con descuento por cantidad");
        Enumeration<Rental> listaRentals2 = Customer2.getRentals();
        Rental ultimoRental2 = null;
        while (listaRentals2.hasMoreElements()){
            ultimoRental2 = listaRentals2.nextElement();
        }
        double price2 = ultimoRental2.getPrice();
        System.out.println("El precio del alquiler con descuento por cantidad es: " + price2 + "\n");
        
        
        // CASO 3: alquiler de coche sin descuento
        Customer3.rentCarOnSite(fecha1, fecha2, coche3, oficina1, null, "Alquiler de coche sin descuento");
        Enumeration<Rental> listaRentals3 = Customer3.getRentals();
        Rental ultimoRental3 = null;
        while (listaRentals3.hasMoreElements()){
            ultimoRental3 = listaRentals3.nextElement();
        }
        double price3 = ultimoRental3.getPrice();
        System.out.println("El precio del alquiler sin descuento es: " + price3 + "\n");


        //CASO 4: aplicar primero una estrategia de descuento y después cambiarla
        Customer4.rentCarOnSite(fecha1, fecha2, coche4, oficina2, amountPromotion, "Alquiler de coche con descuento por cantidad");
        Enumeration<Rental> listaRentals4 = Customer4.getRentals();
        Rental ultimoRental4 = null;
        while (listaRentals4.hasMoreElements()){
            ultimoRental4 = listaRentals4.nextElement();
        }
        double price4 = ultimoRental4.getPrice();
        System.out.println("El precio del alquiler con descuento por cantidad es: " + price4);        
        ultimoRental4.setPromotion(percentagePromotion);
        double price4changed = ultimoRental4.getPrice();
        System.out.println("El precio del alquiler con descuento por porcentaje es: " + price4changed);
    }
}

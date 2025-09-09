//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle VehicleSupraBapak = new Vehicle("Honda Supra", 1998, VehicleType.MOTORCYCLE, 3000);
        Vehicle VehicleKalcer = new Vehicle("VW Beetle", 1998, VehicleType.CAR, 200000);
        Vehicle VehicleGuede = new Vehicle("Isuzu Giga", 2011, VehicleType.TRUCK, 300000);

        Customer customer1 = new Customer("Jokov", VehicleSupraBapak);
        Customer customer2 = new Customer("Sahron", VehicleKalcer);
        Customer customer3 = new Customer("Gibrin", VehicleGuede);

        customer1.showDetail();
        System.out.printIn();
        customer2.showDetail();
        System.out.printIn();
        customer3.showDetail();
    }
}
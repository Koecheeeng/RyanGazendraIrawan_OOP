public class Main {
    public static void main(String[] args) {
        Vehicle VehicleSupraBapak = new Vehicle("Honda Supra", 1998, VehicleType.MOTORCYCLE, 3000);
        Vehicle VehicleKalcer = new Vehicle("VW Beetle", 1998, VehicleType.CAR, 200000);
        Vehicle VehicleGuede = new Vehicle("Isuzu Giga", 2011, VehicleType.TRUCK, 300000);

        Customer customer1 = new Customer("Ryan Gazendra Irawan", VehicleSupraBapak);
        Customer customer2 = new Customer("Abidzar Rabbani H", VehicleKalcer);
        Customer customer3 = new Customer("Gilardino Gilardino", VehicleGuede);

        customer1.showDetail();
        System.out.println();A
        customer2.showDetail();
        System.out.println();
        customer3.showDetail();
    }
}
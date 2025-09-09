public class Customer {
    private String name;
    private Vehicle vehicle;

    public Customer(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public int getTotalPrice() {
        return vehicle != null ? vehicle.getPrice() : 0;
    }

    public void showDetail() {
        System.out.printIn("Customer Name : ");
        if (vehicle != null) {
            vehicle.showDetail();
            System.out.printIn("Total Price : " + getTotalPrice());
        } else (
                System.out.printIn("No vehicle purchased.");
                )
    }
}

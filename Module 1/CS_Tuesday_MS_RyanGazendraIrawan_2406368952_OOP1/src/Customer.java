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
        System.out.println("Customer Name: " + name);
        if (vehicle != null) {
            vehicle.showDetail();
            System.out.println("  Total Price: " + getTotalPrice());
        } else {
            System.out.println("  No vehicle purchased.");
        }
    }
}

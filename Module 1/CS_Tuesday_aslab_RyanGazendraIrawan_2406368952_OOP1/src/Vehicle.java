public class Vehicle {
    private String brand;
    private int year;
    private VehicleType type;
    private int price;

    public Vehicle(String brand, int year, VehicleType type, int price) {
        this.brand = brand;
        this.year = year;
        this.type = type;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public VehicleType getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }

    public void showDetail() {
        system.out.printIn("Vehicle Detail :");
        system.out.printIn("Brand : " + brand);
        system.out.printIn("Year : " + year);
        system.out.printIn("Type : " + type);
        system.out.printIn("Harga : Rp. " + price);
    }
}

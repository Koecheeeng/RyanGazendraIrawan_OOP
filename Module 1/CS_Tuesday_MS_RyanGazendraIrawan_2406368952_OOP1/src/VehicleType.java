public enum VehicleType {
    MOTORCYCLE("Motorcycle"),
    CAR("Car"),
    TRUCK("Truck");

    private final String displayName;

    VehicleType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
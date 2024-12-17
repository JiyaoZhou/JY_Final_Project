public class Customer extends Person {
    private int loyaltyPoints;

    public Customer(String personID, String name, int loyaltyPoints) {
        super(personID, name);
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    @Override
    public String toString() {
        return super.toString() + ", Loyalty Points: " + loyaltyPoints;
    }
}
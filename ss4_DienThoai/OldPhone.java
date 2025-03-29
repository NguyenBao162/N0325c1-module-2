package ss4_DienThoai;

import ss4_validation_DienThoai.PhoneValidation;

public class OldPhone extends Phone implements Discountable {
    private int batteryPercentage;
    private String description;

    public OldPhone() {
    }

    //Contructor
    public OldPhone(String id, String name, double price, int warranty, String manufacturer, int batteryPercentage, String description) {
        super(id, name, price, warranty, manufacturer);
        this.batteryPercentage = batteryPercentage;
        this.description = description;
    }

    //nhập
    public void input() {
        super.input();
        this.batteryPercentage = PhoneValidation.inputBatteryPercentage("Tình Trạng Pin (%)");
        this.description = PhoneValidation.inputDescription("Mô tả thêm: ");
    }

    // xuất
    public void output() {
        super.output();
        System.out.println("Tình trạng pin hiện tại: " + this.batteryPercentage);
        System.out.println("Mô tả thêm: " + this.description);
    }

    public double calculateTotalPrice() {
        return getPrice();
    }

    public void applyDiscount(double percentDiscount) {
        double discountedPrice = getPrice() * (1 - percentDiscount / 100.0);
        setPrice(discountedPrice);
    }

    // getters//setters
    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return super.toString() + String.format(",%s,%s,", batteryPercentage, description);
    }
}

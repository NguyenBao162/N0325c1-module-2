package ss4_DienThoai;

import ss4_validation_DienThoai.PhoneValidation;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
    }

    //Contructor
    public NewPhone(String id, String name, double price, int warranty, String manufacturer, int quantity) {
        super(id, name, price, warranty, manufacturer);
        this.quantity = quantity;
    }

    //Nhập
    public void input() {
        super.input();
        this.quantity = PhoneValidation.inputQuanTity("Số Lượng");
    }

    //xuất
    public void output() {
        super.output();
        System.out.print("Số Lượng là: " + this.quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * quantity;
    }

    //getters
    public int getQuantity() {
        return quantity;
    }

    //setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return super.toString() + String.format(",,,%s,", quantity);
    }
}

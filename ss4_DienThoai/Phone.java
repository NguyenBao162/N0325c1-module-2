package ss4_DienThoai;

import ss4_validation_DienThoai.PhoneValidation;

public abstract class Phone implements Comparable<Phone> {
    private String id;
    private String name;
    private double price;
    private int warranty;
    private String manufacturer;

    public Phone() {
    }

    //Contructor
    public Phone(String id, String name, double price, int warranty, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.manufacturer = manufacturer;
    }

    public abstract double calculateTotalPrice();

    public int compareTo(Phone o) {
        return Double.compare(this.getPrice(), o.price);
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //nhập
    public void input() {
        this.name = PhoneValidation.inputName("Tên Điện Thoại");
        this.price = PhoneValidation.inputPrice("Giá Bán");
        this.warranty = PhoneValidation.inputWarranty("Thời Gian Bảo Hành");
        this.manufacturer = PhoneValidation.inputManufacturer("Hãng Sản Xuất");

    }

    //xuất
    public void output() {
        System.out.println("ID: " + this.id);
        System.out.println("Tên Điện Thoại: " + this.name);
        System.out.println("Giá Bán: " + this.price);
        System.out.println("Thời Gian Bảo Hành: " + this.warranty);
        System.out.println("Hãng Sản Xuất: " + this.manufacturer);
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", id, name, price, warranty, manufacturer);
    }
}

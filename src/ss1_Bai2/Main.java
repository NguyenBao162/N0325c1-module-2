package ss1_Bai2;

public class Main {
    public static void main(String[] args) {
        PhanSo phanSo1 = new PhanSo();
        PhanSo phanSo2 = new PhanSo();

        phanSo1.input();
        phanSo2.input();

        phanSo1.output();
        phanSo2.output();

        System.out.print("Tổng của hai phân số là: ");
        PhanSo tong = phanSo1.cong(phanSo2);
        tong.output();

        System.out.print("Hiệu của hai phân số là: ");
        PhanSo hieu = phanSo1.tru(phanSo2);
        hieu.output();

        System.out.print("Tích của hai phân số là: ");
        PhanSo tich = phanSo1.nhan(phanSo2);
        tich.output();

        System.out.print("Thương của hai phân số là: ");
        PhanSo thuong = phanSo1.chia(phanSo2);
        thuong.output();

        System.out.println("Phân số thứ nhất là phân số " + (phanSo1.laPhanSoDuong() ? "dương" : "âm" + "."));

        System.out.println("Phân số thứ nhất là phân số " + (phanSo2.laPhanSoDuong() ? "dương" : "âm" + "."));
    }
}

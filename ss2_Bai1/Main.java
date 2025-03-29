package ss2_Bai1;

public class Main {
    public static void main(String[] args) {
        PhanSo phanso1 = new PhanSo();
        PhanSo phanSo2 = new PhanSo();
        PhanSo a = new PhanSo();
        a.xuat();
        PhanSo b = new PhanSo(1, 2);
        b.xuat();
        PhanSo c = new PhanSo(3);
        c.xuat();
        PhanSo d = new PhanSo(-6, -2);
        d.xuat();
        PhanSo e = new PhanSo(3, -1);
        e.xuat();
        PhanSo f = e.copy();
        f.Cong(100);
        e.xuat();
        f.xuat();
    }
}

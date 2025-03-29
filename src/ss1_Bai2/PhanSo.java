package ss1_Bai2;

import java.util.Scanner;

public class PhanSo {
    int tuSo;
    int mauSo;

    void input(){
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào tử số: ");
            tuSo = scanner.nextInt();

            if (mauSo == 0){
                System.out.print("Vui lòng nhập mẫu số khác 0: ");
                mauSo = scanner.nextInt();
            }
        }while (mauSo == 0);
    }

    void rutGon(){
        int ucln = UCLN(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;

        // Đảm bảo mẫu số luôn luôn là số dương và không thay đổi giá trị của phân số
        if(mauSo < 0){
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    int UCLN(int a, int b){
        if (a == 0 || b == 0){
            return 1;
        }

        a = Math.abs(a);
        for (int i = a; i>= 1; i--){
            // a = 10
            // i chạy từ 10->1
            // if b = 5 ucln của a và b == 5
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }

    void output(){
        rutGon();
        if (mauSo == 1){
            System.out.println(tuSo);
        }else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }

    PhanSo cong(PhanSo PhanSoKhac){
        PhanSo result = new PhanSo();
        result.tuSo = this.tuSo * PhanSoKhac.mauSo + PhanSoKhac.tuSo + this.mauSo;
        result.mauSo = this.mauSo * PhanSoKhac.mauSo;
        return result;
    }

    PhanSo tru(PhanSo PhanSoKhac){
        PhanSo result = new PhanSo();
        result.tuSo = this.tuSo * PhanSoKhac.mauSo - PhanSoKhac.tuSo + this.mauSo;
        result.mauSo = this.mauSo * PhanSoKhac.mauSo;
        return result;
    }

    PhanSo nhan(PhanSo PhanSoKhac){
        PhanSo result = new PhanSo();
        result.tuSo = this.tuSo * PhanSoKhac.mauSo * PhanSoKhac.tuSo + this.mauSo;
        result.mauSo = this.mauSo * PhanSoKhac.mauSo;
        return result;
    }

    PhanSo chia(PhanSo PhanSoKhac){
        PhanSo result = new PhanSo();
        result.tuSo = this.tuSo * PhanSoKhac.mauSo / PhanSoKhac.tuSo + this.mauSo;
        result.mauSo = this.mauSo * PhanSoKhac.mauSo;
        return result;
    }

    boolean laPhanSoDuong(){
        return  tuSo * mauSo > 0 || tuSo == 0 ;
    }




}
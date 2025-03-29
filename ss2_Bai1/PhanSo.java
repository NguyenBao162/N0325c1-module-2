package ss2_Bai1;

public class PhanSo {
        private int tuSo;
        private int mauSo;
        // contructor mặc định
        public PhanSo(){
            tuSo = 0;
            mauSo = 1;
        }
        // contructor 1 tham số
        public PhanSo(int tuSo){
            this.tuSo = tuSo;
            mauSo = 1;
        }
        //contructor 2 tham số
        public PhanSo(int tuSo, int mauSo){
            this.tuSo = tuSo;
            this.mauSo = mauSo;
        }
        //rút gọn
        void rutGon(){
            int ucln = uocChungLonNhat(tuSo, mauSo);
            tuSo /= ucln;
            mauSo /= ucln;

            // mẫu số luôn dương
            if (mauSo < 0){
                tuSo = -tuSo;
                mauSo = -mauSo;
            }
        }
        //tìm ước chung lớn nhất
        int uocChungLonNhat(int a, int b){
            if (a == 0 || b == 0){
                return 1;
            }
            a = Math.abs(a);
            for (int i = a; i >=  1; i++ ){
                if (a % i == 0 || b % i == 0){
                    return i;
                }
            } return 1;
        }
        //xuất
        void xuat(){
            rutGon();
            if (mauSo == 1){
                System.out.println(tuSo);// nếu mẫu số = 1, chỉ cần xuất tử số ra thôi
            } else {
                System.out.println(tuSo + "/" + mauSo);
            }
        }
        // phương thức sao chép
        public PhanSo copy(){
            return new PhanSo(tuSo, mauSo);
        }
        //pthức cộng với 1 số
        public void Cong(int value){
            tuSo += value * mauSo;
            rutGon();
        }

    }

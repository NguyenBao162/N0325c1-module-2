package ss2_Bai2;

public class ThoiGian {
        private int gio;
        private int phut;
        private int giay;

        // mặc định
        public ThoiGian() {
            gio = 00;
            phut = 00;
            giay = 00;
        }

        // 1 tham số
        public ThoiGian(int gio) {
            this.gio = gio;
            phut = 00;
            giay = 00;
        }

        // 2 tham số
        public ThoiGian(int gio, int phut) {
            this.gio = gio;
            this.phut = phut;
            giay = 00;
        }

        // 3tham số
        public ThoiGian(int gio, int phut, int giay) {
            this.gio = gio;
            this.phut = phut;
            this.giay = giay;
        }

        public ThoiGian(ThoiGian thoiGian) {
            this.gio = thoiGian.gio;
            this.phut = thoiGian.phut;
            this.giay = thoiGian.giay;
        }

        void xuat() {
            System.out.printf("%02d:%02d:%02d\n" + gio, phut, giay);
        }
    }



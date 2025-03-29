package ss5_Bai1;

public class Overload_Override {
    //------TH1-----
//package abc;
//    public class HocVien {
//        public void a() {
//            System.out.println("a cha");
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void a() {
//            System.out.println("a con");
//        }
    //override bởi vì cả 2 đều có cùng phương thức a(), cùng tên cùng tham số và pthức a() của SinhVien sẽ thay đổi hành vi của a() HocVien (in ra "a con" thay vì "a cha")

    //------TH2------
//package abc;
//    public class HocVien {
//        void a() {
//            System.out.println("a cha");
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void a() {
//            System.out.println("a con");
//        }
//    }
    //vẫn là override bởi vì Phạm vi truy cập của phương thức ghi đè có thể rộng hơn hoặc bằng với phạm vi truy cập của phương thức bị ghi đè
    // ở đây phương thức ghi đè là public void a() trong  class SinhVien và bị ghi đè là class HocVien

    //------TH3----
//package abc;
//    public class HocVien {
//        private void a() {
//            System.out.println("a cha");
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void a() {
//            System.out.println("a con");
//        }
//    }
    // do class HocVien dang là private nên class SinhVien không thể ghi đè (override) được nên 2 cái này là phương thức độc lập
    //private chỉ có thể được truy cập bên trong lớp mà nó được định nghĩa nên SinhVien dùng public sẽ không ghi đè được HocVien

    //-----TH4----
//package abc;
//    public class HocVien {
//        public void a() {
//            System.out.println("a cha");
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        protected void a() {
//            System.out.println("a con");
//        }
//    }
    //SinhVien sẽ ghi đè HocVien bởi vì phạm vi truy cập của phương thức ghi đè (protected) có thể rộng hơn hoặc bằng với phạm vi truy cập của phương thức bị ghi đè (public)
    // trong kế thừa protected rộng hơn public nên SinhVien sẽ ghi đè HocVien và xuất ra "a con"

    //----TH5---
//package abc;
//    public class HocVien {
//        public byte a() {
//            System.out.println("a cha");
//            return 1;
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public int a() {
//            System.out.println("a con");
//            return 1;
//        }
//    }
    // là Overload bởi vì Overload xảy ra khi các phương thức có cùng tên nhưng khác nhau về tham số hoặc kiểu trả về,
    // ở đây kiểu trả về khác nhau (byte vs. int), nên đây là overload
    //a() trong SinhVien sẽ không ghi đè a() trong HocVien, thay vào đó, nó là một phương thức mới được định nghĩa trong SinhVien với cùng tên nhưng kiểu trả về khác

    //-----TH6---
//package abc;
//    public class HocVien {
//        public Animal a() {
//            System.out.println("a cha");
//            return null;
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public Dog a() {
//            System.out.println("a con");
//            return null;
//        }
//    }
    //override
    //Lớp SinhVien ghi đè phương thức a() từ lớp HocVien và thay đổi kiểu trả về từ Animal thành Dog (giả sử Dog là lớp con của Animal). Điều này là hợp lệ trong Java khi ghi đè.

    //------TH7----
//package abc;
//    public class HocVien {
//        public void a(){
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void a(int i){
//        }
//    }
    //Phương thức a() trong HocVien không có tham số nào, còn SinhVien thì có 1 tham số kiểu INT
    //Overload xảy ra khi các phương thức có cùng tên nhưng khác nhau về tham số (số lượng hoặc kiểu dữ liệu).
    // nên đây là overload

    //-----TH8----

//package abc;
//public class HocVien {
//    public static void a() {
//    }
//}
//package abc;
//    public class SinhVien extends HocVien {
//        public static void a() {
//        }
//    }
    // không phải override cũng như overload ở đây bởi vì cả 2 đều được định nghĩa static và có tên giống nhau
    // trong java một phương thức static không thể override
    // pthức a() trong SinhVien chỉ là ẩn đi a() trong HocVien

    //------TH9-----
//package abc;
//    public class HocVien {
//        public void a(int b, int c) {
//            System.out.println(b + "" + c)
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void a(double d, int c){
//            System.out.println(d+""+c)
//        }
    //overload bởi vì SinhVien tham số là double còn HocVien là int , tuy cùng tên nhưng khác tham số

    //----TH10------
//package abc;
//    public class HocVien {
//        public void a(int b, int c) {
//            System.out.println(b + "" + c)
//        }
//    }
//package abc;
//    public class SinhVien extends HocVien {
//        public void b(double d, int c){
//            System.out.println(d+""+c)
//        }
//    }
    //không có hiện tượng gì bởi vì class SinhVien thêm một pthức mới là b(double d, int c) không tồn tại trong class HocVien
}

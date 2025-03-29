package ss5_Bai2;

public class Main {
//
//    HocVien hocVien1 = new HocVien(); Dòng này hợp lệ. Tạo một đối tượng HocVien
//    HocVien hocVien2 = (SinhVien) hocVien1; Lỗi Runtime. hocVien1 là một đối tượng HocVien thuần túy, không phải SinhVien, nên không thể ép kiểu xuống (downcasting) được.
//    ChuyenVien hocVien3 = (ChuyenVien) hocVien2; Lỗi Runtime. hocVien2 đã lỗi ở dòng trên, dẫn đến việc dòng này cũng phát sinh lỗi.
//    NVChinhThuc hocVien4 = hocVien3;Lỗi Compile. hocVien3 có kiểu ChuyenVien, cần ép kiểu tường minh sang NVChinhThuc.
//    HocVien hocVien5 = hocVien3;Dòng này hợp lệ. Đây là ép kiểu lên (upcasting) ngầm định, vì ChuyenVien là lớp con của HocVien.
//    HocVien hocVien6 = (HocVien) hocVien2;Về mặt cú pháp thì đúng, nhưng bản thân hocVien2 đã bi lỗi runtime từ trước.
//    HocVien hocVien7 = (NVQuanLy) hocVien6;Lỗi Runtime nếu hocVien6 không phải là một instance của NVQuanLy.
//    NVChinhThuc hocVien8 = (NVChinhThuc) hocVien7; Lỗi Runtime nếu hocVien7 không phải là một instance của NVChinhThuc.
//    SinhVien hocVien9 =  (SinhVien) hocVien3;Lỗi Runtime nếu hocVien3 không phải là một instance của SinhVien hoặc lớp con của SinhVien.
//    HocVien hocVien10 = new SinhVien();Dòng này hợp lệ. Tạo một đối tượng SinhVien và gán cho biến kiểu HocVien (upcasting).
//    ChuyenVien hocVien11 = (ChuyenVien) hocVien10;Lỗi Runtime. hocVien10 là SinhVien, không phải ChuyenVien.
}

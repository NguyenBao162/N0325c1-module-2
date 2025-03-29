package ss4_DienThoai;

import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_PHONE = "ss4_DienThoai/Phone.java";

    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static ArrayList<NewPhone> newPhones = new ArrayList<>();
    static ArrayList<Phone> phones = new ArrayList<>();

    static {
        // thêm điện thoại cũ
        oldPhones.add(new OldPhone("DTC001", "Iphone 16 ProMax 1TB", 42990000.0, 3, "Apple", 99, "Hàng likeNew, bao check test "));
        oldPhones.add(new OldPhone("DTC002", "Iphone 13 ProMax 512GB", 15299000.0, 5, "Apple", 95, "Hàng Đẹp Giá Tốt, Bao Xanh Màn "));
        // thêm điện thoại mới
        newPhones.add(new NewPhone("DTM001", "Samsung Galaxy S24 Ultra", 44490000.0, 7, "Samsung", 19));
        newPhones.add(new NewPhone("DTM002", "Samsung Galaxy S23 Ultra", 21690000.0, 18, "Samsung", 21));
    }

    public static void main(String[] args) {
        int choose;
        while (true) {
            try {
                System.out.println("-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -- ");
                System.out.println("1. Xem Danh Sách Điện Thoại");
                System.out.println("2. Thêm Mới");
                System.out.println("3. Cập Nhật");
                System.out.println("4. Xoá");
                System.out.println("5. Sắp Xếp Theo Giá");
                System.out.println("6. Tìm Kiếm");
                System.out.println("7. Tính Tổng Tiền");
                System.out.println("8. Giảm Giá Cho Điện Thoại");
                System.out.println("9. Thoát");

                System.out.print("Mời Người Đẹp Chọn Số: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        menuShowList();
                        break;
                    case 2:
                        menuAddNew();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        menuSort();
                        break;
                    case 6:
                        menuSearch();
                        break;
                    case 7:
                        System.out.print("Tổng giá của tất cả các điện thoại: " + calculateTotalPriceInStore());
                        break;
                    case 8:
                        System.out.print("Nhập vào % muốn giảm giá: ");
                        double percentDiscount = Double.parseDouble(scanner.nextLine());
                        applyDiscountToOldPhone(percentDiscount);
                        System.out.println("Đã giảm giá thành công");
                        break;
                    case 9:
                        return;
                    default:
                        System.out.print("Lựa Chọn Không Hợp Lệ, Xin Chọn Lại");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ứng dụng gặp một số lỗi không mong muốn " + " xin vui lòng thử lại các chức năng");
            }
        }
    }

    private static void menuShowList() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        while (true) {
            int choose;
            do {
                System.out.println("==== 1. Xem danh sách điên thoại ====");
                System.out.println("1. Xem tất cả");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Nhập vào lựa chọn của bạn: ");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("==== Danh Sách Tất Cả Điện Thoại ====");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Thông Tin Điện Thoại thứ " + (i + 1));
                            phones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("=== Danh Sách Điện Thoại Cũ ===");
                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof OldPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("=== Danh Sách Điện Thoại Mới ===");
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof NewPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 0) || (choose > 4));
        }
    }

    private static void menuAddNew() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("==== 2. Thêm mới ====");
                System.out.println("1. Thêm điện thoại cũ");
                System.out.println("2. Thêm điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone(phones));
                        phones.add(oldPhone);
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone(phones));
                        phones.add(newPhone);
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 1) || (choose > 3));
        }
    }

    private static void update() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        System.out.println("Nhập vào Id bạn muốn cập nhật: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            // isExist: Tồn tại
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    phone.input();
                    WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
                    System.out.println("Cập Nhật Thành Công");
                    break;
                }
            }
            if (!isExistPhone) {
                System.out.println("Không tìm thấy id ");
            }
        } else {
            System.out.println("Id không hợp lệ");
        }
    }

    private static void delete() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        System.out.println("Nhập vào mã muốn xóa");
        String id = scanner.nextLine();

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    System.out.printf("Bạn muốn xoá điện thoại mã %s không?\n", id);
                    System.out.println("Chọn Yes để xác nhận, No để huỷ");
                    if ("Yes".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
                        System.out.println("Xoá thành công");
                    } else {
                        System.out.println("Đã huỷ lệnh xoá");
                    }
                    break;
                }
            }
            if (!isExistPhone) {
                System.out.println("Không tìm thấy id muốn xoá");
            }
        } else {
            System.out.println("Id không hợp lệ");
        }
    }

    private static void menuSort() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("==== 5. Sắp xếp theo giá ====");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                System.out.println("3. Trở về menu chính");

                System.out.print("Nhập vào lựa chọn của bạn: ");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        Collections.sort(phones);
                        break;
                    case 2:
                        phones.sort(Collections.reverseOrder());
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 0) || (choose > 3));
        }
    }

    private static void menuSearch() throws IOException {
        int choose;
        while (true) {
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm tất cả các loại điện thoại");
                System.out.println("2. Tìm kiếm điện thoại củ");
                System.out.println("3. Tìm kiếm điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Nhập vào lựa chọn của bạn: ");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm ");
                        System.out.println("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.println("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manuFacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getManufacturer().contains(manuFacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 0) || (choose > 4));
        }

    }

    private static void menuSearchNewPhone() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.print("Nhập vào lựa chọn của bạn: ");
                choose = Integer.parseInt(scanner.nextLine());
                // lấy ra danh sách điện thoại mới từ danh sách điện thoại
                ArrayList<NewPhone> newPhones = getNewPhones(phones);
                switch (choose) {
                    case 1:
                        System.out.print("Nhập vào khoảng giá trị muốn tìm: ");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());
                        int count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 0) || (choose > 4));
        }
    }

    private static void menuSearchOldPhone() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                // lấy ra danh sách điện thoại cũ từ danh sách điện thoại
                ArrayList<OldPhone> oldPhones = getOldPhones(phones);
                switch (choose) {
                    case 1:
                        System.out.print("Nhập vào khoảng giá trị muốn tìm: ");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());
                        System.out.println("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());
                        int count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ: " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 0) || (choose > 4));
        }
    }

    private static void menuSearchAllPhone() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        while (true) {
            int choose;
            do {
                System.out.println("==== 6. Tìm kiếm ====");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu tìm kiếm");

                System.out.println("Nhập vào lựa chọn của bạn");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        // ??
                        break;
                    case 2:
                        // ??
                        break;
                    case 3:
                        // ??
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Xin vui lòng chọn lại!");
                }
            } while ((choose < 1) || (choose > 4));
        }

    }

    private static String getIdOldPhone(List<Phone> phones) {
        //max id => id + 1
        //lấy ra danh sách điện thoại cũ từ danh sach điện thoại
        ArrayList<OldPhone> oldPhones = getOldPhones(phones);
        if (oldPhones.size() == 0) {
            return "DTC001";
        }
        // oldPhones.get(0).getId(): CHỌN RA ID CỦA DTH CŨ ĐẦU TIÊN
        // substring(3)); lẫy chuỗi con vị trí t3 từ chuỗi DTC001
        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3));

        for (int i = 0; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    // lọc ra dth cũ
    private static ArrayList<OldPhone> getOldPhones(List<Phone> phones) {
        ArrayList<OldPhone> oldPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                oldPhones.add((OldPhone) phone);
            }
        }
        return oldPhones;
    }

    private static String getIdNewPhone(List<Phone> phones) {
        // max id => id + 1
        // lấy ra danh sách điện thoại mới từ danh sách điện thoại
        ArrayList<NewPhone> newPhones = getNewPhones(phones);
        if (newPhones.size() == 0) {
            return "DTM001";
        }

        // newPhones.get(0).getId(): tương tự oldphone
        // substring(3)); tương tự oldphone
        int max = Integer.parseInt(newPhones.get(0).getId().substring(3));

        for (int i = 0; i < newPhones.size(); i++) {
            int id = Integer.parseInt(newPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTM%3d", max + 1).replace(" ", "0");
    }

    // lọc ra dth mới
    private static ArrayList<NewPhone> getNewPhones(List<Phone> phones) {
        ArrayList<NewPhone> newPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof NewPhone) {
                newPhones.add((NewPhone) phone);
            }
        }
        return newPhones;
    }

    //tính tổng giá của all điện thoại
    private static double calculateTotalPriceInStore() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        double total = 0.0;
        for (Phone phone : phones) {
            total += phone.calculateTotalPrice();
        }
        return total;
    }

    // áp dụng giảm giá cho dth cũ
    public static void applyDiscountToOldPhone(double percentDiscount) throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).applyDiscount(percentDiscount);
            }
        }
        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
    }
}


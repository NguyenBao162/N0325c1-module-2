package ss4_DienThoai;

import ss4_exception_dienthoai.EmtyFieldException;
import ss4_exception_dienthoai.MinLegthException;
import ss4_exception_dienthoai.NegativeNumberException;
import ss4_exception_dienthoai.NumberOutOfRangeException;
import ss4_validation_DienThoai.CommonValidation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileUtil {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();
        return strings;
    }

    public static List<Phone> readPhonesFile(String path) throws IOException {
        List<String> lines = volidatePhones(path);
        List<Phone> phones = new ArrayList<>();
        Phone phone;
        String[] info;
        for (String line : lines) {
            info = line.split(",");
            if (info[0].startsWith("DTC")) {
                OldPhone oldPhone = new OldPhone();
                oldPhone.setBatteryPercentage(Integer.parseInt(info[5]));
                oldPhone.setDescription(info[6]);

                phone = oldPhone;
            } else {
                NewPhone newPhone = new NewPhone();
                newPhone.setQuantity(Integer.parseInt(info[7]));

                phone = newPhone;
            }
            phone.setId(info[0]);
            phone.setName(info[1]);
            phone.setPrice(Double.parseDouble(info[2]));
            phone.setWarranty(Integer.parseInt(info[3]));
            phone.setManufacturer(info[4]);

            phones.add(phone);
        }
        return phones;
    }

    private static List<String> volidatePhones(String path) throws IOException {
        List<String> LinesValidated = new ArrayList<>();
        List<String> lines = readFile(path);

        String[] info;
        StringBuilder errorMessage = new StringBuilder();// tổng toàn bộ lỗi của file Phone
        StringBuilder errorLineMessage; // thông tin 1 lỗi
        for (int i = 0; i < lines.size(); i++) {
            errorLineMessage = new StringBuilder();
            info = lines.get(i).split(",");

            // mã điện thoại
            if (!info[0].startsWith("DTC") && !info[0].startsWith("DTM")) {
                addMessage(errorLineMessage, "Mã điện thoại không đúng định dạng", i);
            }
            //tên điện thoại
            try {
                CommonValidation.validateIsEmpty(info[1], "tên điện thoại");
            } catch (EmtyFieldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            //giá bán
            try {
                CommonValidation.validateIsEmpty(info[2], "Giá Bán");
            } catch (EmtyFieldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            double price = 0;
            try {
                price = CommonValidation.parseDouble(info[2], "Giá Bán");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }

            try {
                CommonValidation.validateIsNegativeNumber(price, "Giá Bán");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            //thời gian bảo hành
            try {
                CommonValidation.validateIsEmpty(info[3], "Thời Gian Bảo Hành");
            } catch (EmtyFieldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }

            int warranty = 0;
            try {
                warranty = CommonValidation.parseInt(info[3], "Thời Gian Bảo Hành");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            try {
                CommonValidation.validateIsNegativeNumber(warranty, "Thời Gian Bảo Hành");
            } catch (NegativeNumberException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            // Năm Sản Xuất
            try {
                CommonValidation.validateIsEmpty(info[4], "Hãng Sản Xuất");
            } catch (EmtyFieldException e) {
                e.printStackTrace();
                addMessage(errorLineMessage, e.getMessage(), i);
            }
            // kiểm tra thông tin của điện thoại cũ
            if (info[0].startsWith("DTC")) {
                //tình trạng pin
                try {
                    CommonValidation.validateIsEmpty(info[5], "Thời Gian Bảo Hành");
                } catch (EmtyFieldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                int batteryPercentage = 0;
                try {
                    batteryPercentage = CommonValidation.parseInt(info[5], "Thời Gian Bảo Hành");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                try {
                    CommonValidation.validateNumberOutOfRageException(batteryPercentage, "Thời Gian Bảo Hành", 0, 100);
                } catch (NumberOutOfRangeException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                // mô tả thêm
                try {
                    CommonValidation.validateIsEmpty(info[6], "Mô Tả Thêm");
                } catch (EmtyFieldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
                try {
                    CommonValidation.validateMinLength(info[6], "Mô Tả Thêm", 10);
                } catch (MinLegthException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
            }

            //kiểm tra thông tin điện thoại mới
            if (info[0].startsWith("DTM")) {
                //sỐ LƯỢNG
                try {
                    CommonValidation.validateIsEmpty(info[7], "Số lượng");
                } catch (EmtyFieldException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }

                int quantity = 0;
                try {
                    quantity = CommonValidation.parseInt(info[7], "Số Lượng");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }

                try {
                    CommonValidation.validateIsNegativeNumber(quantity, "Số Lượng");
                } catch (NegativeNumberException e) {
                    e.printStackTrace();
                    addMessage(errorLineMessage, e.getMessage(), i);
                }
            }

            //kiểm tra dòng hiện tại có lỗi hay không
            if (errorLineMessage.length() != 0) { // dòng hiện tại có lỗi
                if (errorMessage.length() != 0) {
                    errorMessage.append("\n");
                }
                errorMessage.append(errorLineMessage);
            } else { // dòng hiện tại kh lỗi thì đưa vào List
                LinesValidated.add(lines.get(i));
            }
        }
        // ghi dòng lỗi vào file
        WriteFileUtil.writeFile("ss4_DienThoai/data/error.txt", errorMessage.toString());
        return LinesValidated;
    }

    private static void addMessage(StringBuilder errorLineMessage, String message, int lineNumber) {
        if (errorLineMessage.length() == 0) {
            errorLineMessage.append(String.format("Dòng %s:", lineNumber + 1));
        } else {
            errorLineMessage.append(" , ");
        }

        errorLineMessage.append(message);
    }
}

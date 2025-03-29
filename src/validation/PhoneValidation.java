package validation;

import java.util.Scanner;

public class PhoneValidation {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputName(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String name = scanner.nextLine();

                CommonValidation.validateIsEmpty(name, fieldName);
                return name;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static double inputPrice(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String priceStr = scanner.nextLine();

                CommonValidation.validateIsEmpty(priceStr, fieldName);
                double price = CommonValidation.parseDouble(priceStr, fieldName);
                CommonValidation.validateIsNegativeNumber(price, fieldName);
                return price;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static int inputWarranty(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String warrantyStr = scanner.nextLine();

                CommonValidation.validateIsEmpty(warrantyStr, fieldName);
                int warranty = CommonValidation.parseInt(warrantyStr, fieldName);
                CommonValidation.validateIsNegativeNumber(warranty, fieldName);
                return warranty;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static String inputManufacturer(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String manufacture = scanner.nextLine();

                CommonValidation.validateIsEmpty(manufacture, fieldName);

                return manufacture;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static Integer inputBatteryPercentage(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String batteryPercentageStr = scanner.nextLine();

                CommonValidation.validateIsEmpty(batteryPercentageStr, fieldName);
                int batteryPercentage = CommonValidation.parseInt(batteryPercentageStr, fieldName);
                CommonValidation.validateNumberOutOfRageException(batteryPercentage, fieldName, 0, 100);
                return batteryPercentage;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static String inputDescription(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String description = scanner.nextLine();

                CommonValidation.validateIsEmpty(description, fieldName);
                CommonValidation.validateMinLength(description, fieldName, 10);
                return description;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }

    public static Integer inputQuanTity(String fieldName) {
        while (true) {
            try {
                System.out.printf("Nhập vào %s: ", fieldName);
                String quanTityStr = scanner.nextLine();

                CommonValidation.validateIsEmpty(quanTityStr, fieldName);
                int quantity = CommonValidation.parseInt(quanTityStr, fieldName);
                CommonValidation.validateIsNegativeNumber(quantity, fieldName);
                return quantity;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("xin nhập lại");
            }
        }
    }
}

package validation;

import Exception.EmtyFieldException;
import Exception.MinLegthException;
import Exception.NegativeNumberException;
import Exception.NumberOutOfRangeException;

public class CommonValidation {
    public static void validateIsEmpty(String value, String fieldName) throws EmtyFieldException {
        if (value.isEmpty()) {
            throw new EmtyFieldException(fieldName + "không được trống");
        }
    }

    public static int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " không phải số nguyên");
        }
    }

    public static double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(fieldName + " phải là số thực");
        }
    }

    public static void validateNumberOutOfRageException(double value, String fieldName, double minValue, double maxValue)
            throws NumberOutOfRangeException {
        if (value < minValue || value > maxValue) {
            throw new NumberOutOfRangeException(String.format("%s nằm ngoài khoảng giá trị hợp lệ [%s, %s]", fieldName, minValue, maxValue));
        }
    }

    public static void validateMinLength(String value, String fieldName, int minLength) throws MinLegthException {
        if (value.length() < minLength) {
            throw new MinLegthException(String.format("%s phải có ít nhất %s ký tự", fieldName, minLength));
        }
    }

    public static void validateIsNegativeNumber(double value, String fieldName) throws NegativeNumberException {
        if (value < 0) {
            throw new NegativeNumberException(fieldName + "không được số âm");
        }
    }
}

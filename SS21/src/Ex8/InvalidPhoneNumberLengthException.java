package Ex8;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (!phone.matches("\\d{10}") ) {
            throw new InvalidPhoneNumberLengthException("Số điện thoại chứa ký tự không hợp lệ");
        }
        if (phone == null || phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Số điện thoại phải có đúng 10 chữ số.");
        }
    }
}

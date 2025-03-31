package presentation;

import util.Validator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        validator.validateInteger(scanner,"Nhập vào 1 số kiểu integer");
        validator.validateFloat(scanner,"Nhập vào 1 số kiểu float");
        validator.validateDouble(scanner, "Nhập vào 1 số kiểu double");
        validator.validateString(scanner ,"Nhập vào 1 chuỗi kiểu String",10,2);
        validator.validateEmail(scanner, "Nhập vào 1 email ");
        validator.validateBoolean(scanner,"Nhập kiểu boolean");
    }
}

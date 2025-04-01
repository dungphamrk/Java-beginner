package ra.presentation;

import ra.bussiness.CustomerBusiness;

import java.util.Scanner;

import static ra.validate.Validator.validateCustomerId;
import static ra.validate.Validator.validateInt;

public class CustomerApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayCustomerMenu(scanner);
    }
    public static void displayCustomerMenu(Scanner scanner){
        CustomerBusiness customerBusiness = new CustomerBusiness();
        do {
            System.out.println("----------------------------Customer Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp");
            System.out.println("0.Thoát chương trình");
            System.out.println("-----------------------------------------------------------");
            int choice=validateInt(scanner, "Nhập lựa chọn của bạn: ");
            switch (choice){
                case 1:
                    customerBusiness.displayCustomerList();
                    break;
                case 2:
                    customerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    customerBusiness.editCustomerInfo(scanner);
                    break;
                case 4:
                    customerBusiness.delCustomer(scanner);
                    break;
                case 5:
                    customerBusiness.findCustomer(scanner);
                    break;
                case 6:
                    customerBusiness.sortCustomer(scanner);
                    break;
                case 0:
                    return;
            }
        }while (true);


    }
}

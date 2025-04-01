package ra.bussiness;

import ra.entity.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static ra.validate.Validator.*;

public class CustomerBusiness {
    public static List<Customer> listCustomer = new ArrayList<Customer>();

    public void displayCustomerList() {
        if (listCustomer.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        listCustomer.forEach(Customer::displayData);
    }

    public void addCustomer(Scanner scanner) {
        int numberNewCustomer = validateInt(scanner, "Nhập số lượng khách hàng cần thêm");
        for (int i = 0; i < numberNewCustomer; i++) {
            Customer newCustomer = new Customer();
            newCustomer.inputData(scanner);
            listCustomer.add(newCustomer);
        }
        System.out.println("Đã thêm khách hàng thành công");
    }

    public void editCustomerInfo(Scanner scanner) {
        String editCustomerId = validateCustomerId(scanner, "Nhập vào mã id của khách hàng cần chỉnh sửa");
        if(listCustomer.stream().anyMatch(customer -> customer.getCustomerId().equals(editCustomerId))){
            do {
                System.out.println("Chọn thuộc tính cần sửa của khách hàng đó");
                System.out.println("1.Tên khách hàng");
                System.out.println("2.Họ khách hàng");
                System.out.println("3.Ngày tháng năm sinh");
                System.out.println("4.Số điện thoại");
                System.out.println("5.Giới tính");
                System.out.println("6.Địa chỉ");
                System.out.println("7.Loại khách hàng");
                System.out.println("8.Thoát");
                int choice = validateInt(scanner,"Nhập lựa chọn của bạn");
                switch (choice){
                    case 1:
                        listCustomer.stream().filter(customer -> customer.getCustomerId().equals(editCustomerId))
                                .findFirst().ifPresent(customer -> customer.setFirstName(validateString(scanner,"Nhập vào tên mới của khách hàng",50,0)));
                        break;
                    case 2:
                        listCustomer.stream().filter(customer -> customer.getCustomerId().equals(editCustomerId))
                                .findFirst().ifPresent(customer -> customer.setLastName(validateString(scanner,"Nhập vào họ mới của khách hàng",30,0)));
                        break;
                    case 3:
                        listCustomer.stream().filter(customer -> customer.getCustomerId().equals(editCustomerId))
                                .findFirst().ifPresent(customer -> customer.setFirstName(validateDate(scanner,"Nhập vào ngày tháng năm sinh mới của khách hàng")));
                        break;
                    case 4:
                        break;
                    case 8:
                        return;
                }
            }while (true);
        }
    }

    public void sortCustomer(Scanner scanner) {
        do {
            System.out.println("1.Sắp xếp theo tên tăng dần ");
            System.out.println("2.Sắp xếp theo tên giảm dần");
            System.out.println("3.Sắp xếp theo năm sinh tăng dần");
            System.out.println("4.Sắp xếp theo năm sinh giảm dần");
            System.out.println("0.Thoát");
            int choice = validateInt(scanner, "Vui lòng nhập lựa chọn của bạn");
            switch (choice) {
                case 1:
                    listCustomer.stream().sorted(Comparator.comparing(Customer::getFirstName)).forEach(Customer::displayData);
                    break;
                case 2:
                    listCustomer.stream().sorted(Comparator.comparing(Customer::getLastName).reversed()).forEach(Customer::displayData);
                    break;
                case 3:
                    listCustomer.stream().sorted(Comparator.comparing(Customer::getDateOfBirth)).forEach(Customer::displayData);
                    break;
                case 4:
                    listCustomer.stream().sorted(Comparator.comparing(Customer::getDateOfBirth).reversed()).forEach(Customer::displayData);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Vui lòng nhập từ 0 ->4");
                    break;
            }
        } while (true);
    }

    public void findCustomer(Scanner scanner) {
        do {
            System.out.println("1.Tìm kiếm theo tên khác hàng");
            System.out.println("2.Tìm kiếm theo loại khách hàng");
            System.out.println("3.Tìm kiếm theo số điện thoại");
            System.out.println("0.Thoát");
            int choice = validateInt(scanner, "Nhập lựa chọn của bạn");
            switch (choice) {
                case 1:
                    String findedCustomerName = validateString(scanner, "Vui lòng nhập vào tên khách hàng bạn muốn tìm", 50, 0);
                    if (listCustomer.stream()
                            .anyMatch(customer -> customer.getFirstName().equals(findedCustomerName))) {
                        listCustomer.stream()
                                .filter(customer -> customer.getFirstName().equals(findedCustomerName)).findFirst().get().displayData();
                    }
                    break;
                case 2:
                    String typeCustomer = validateString(scanner, "Nhập vào loại khách hàng bạn muốn tìm", 100, 0);
                    listCustomer.stream().filter(customer -> customer.getCustomerType().equals(typeCustomer)).forEach(Customer::displayData);
                    break;
                case 3:
                    String findPhoneNumber= validateString(scanner,"Nhập vào số điện thoại bạn muốn tìm",100,0);
                    listCustomer.stream().filter(customer -> customer.getPhoneNumber().equals(findPhoneNumber)).findFirst().get().displayData();
                    break;
                case 0:
                    return;
            }
        } while (true);
    }
    public void delCustomer(Scanner scanner){
        String delCustomerId = validateCustomerId(scanner, "Nhập vào mã id của khách hàng cần  xóa");
        if(listCustomer.stream().anyMatch(customer -> customer.getCustomerId().equals(delCustomerId))) {
            do{
                System.out.println("Bạn có thật sự muốn xóa hay ko ? ");
                System.out.println("1.Có");
                System.out.println("2.Thoát");
                int choice  = validateInt(scanner,"Nhập lựa chọn của bạn");
                switch (choice){
                    case 1:
                        listCustomer.removeIf(customer -> customer.getCustomerId().equals(delCustomerId));
                    case 2:
                        return;
                    default:
                        System.out.println("Vui lòng nhập lại lựa chọn của bạn ");
                }
            }while(true);
        }
        System.out.println("Mã khách hàng đó không tồn tại");
    }
}

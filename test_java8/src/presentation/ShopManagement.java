package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;

import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        displayShopMenu(scanner);
    }
    public static void displayShopMenu(Scanner scanner){
        do{
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayCustomerMenu(scanner);
                    break;
                case 2:
                    displayOrderMenu(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3");
                    break;
            }
        }
        while(true);
    }
    public static void displayCustomerMenu(Scanner scanner){
        do{
            System.out.println("**********************CUSTOMER MENU*********************");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2.Thêm mới khách hàng");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    CustomerBusiness.displayCustomers();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3");
                    break;
            }
        }
        while(true);
    }
    public static void displayOrderMenu(Scanner scanner){
        OrderBusiness orderBusiness = new OrderBusiness();
        do{
            System.out.println("**********************ORDER MENU********************");
            System.out.println("1.Danh sách đơn hàng");
            System.out.println("2.Thêm mới đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4.Danh sách đơn hàng quá hạn");
            System.out.println("5.Thống kê số lượng đơn hàng đã giao (Trạng thái true)");
            System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    orderBusiness.displayOrders();
                    break;
                case 2:
                    orderBusiness.addOrder(scanner);
                    break;
                case 3:
                    orderBusiness.updateOrderStatus(scanner);
                    break;
                case 4:
                    orderBusiness.getOrderOverdue().forEach(System.out::println);
                    break;
                case 5:
                    orderBusiness.getOrderDelivired().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Tổng tiền của các đơn hàng là: "+ orderBusiness.getOrderOverdue());
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3");
                    break;
            }
        }
        while(true);
    }
}

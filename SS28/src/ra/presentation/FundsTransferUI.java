package ra.presentation;

import ra.business.model.FundsTransfer;
import ra.business.service.fundstranfer.FundsTransferService;
import ra.business.service.fundstranfer.FundsTransferServiceImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FundsTransferUI {
    private static final FundsTransferService fundsTransferService = new FundsTransferServiceImp();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void displayFundsTransferMenu(Scanner scanner) {
        do {
            System.out.println("*****************FT MENU***************");
            System.out.println("1. Lịch sử giao dịch");
            System.out.println("2. Thống kê số tiền chuyển trong khoảng từ ngày đến ngày");
            System.out.println("3. Thống kê số tiền nhận theo tài khoản");
            System.out.println("4. Thống kê số giao dịch thành công từ ngày đến ngày");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayTransactionHistory();
                    break;
                case 2:
                    getTotalSentAmount(scanner);
                    break;
                case 3:
                    getTotalReceivedAmount(scanner);
                    break;
                case 4:
                    getSuccessfulTransactionsCount(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (true);
    }

    private static void displayTransactionHistory() {
        List<FundsTransfer> transactions = fundsTransferService.getTransactionHistory();
        if (transactions.isEmpty()) {
            System.out.println("Không có giao dịch nào trong lịch sử.");
        } else {
            System.out.println("=== LỊCH SỬ GIAO DỊCH ===");
            for (FundsTransfer transaction : transactions) {
                System.out.printf("ID: %d | Từ: %s (ID: %d) | Đến: %s (ID: %d) | Số tiền: %.2f | " +
                                "Thời gian: %s | Trạng thái: %s%n",
                        transaction.getTransactionId(),
                        transaction.getSenderName(), transaction.getSenderId(),
                        transaction.getReceiverName(), transaction.getReceiverId(),
                        transaction.getAmount(),
                        transaction.getTransactionDate().format(formatter),
                        transaction.getStatus());
            }
        }
    }

    private static void getTotalSentAmount(Scanner scanner) {
        try {
            System.out.println("Nhập ngày bắt đầu (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime startDate = LocalDateTime.parse(scanner.nextLine(), formatter);
            System.out.println("Nhập ngày kết thúc (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime endDate = LocalDateTime.parse(scanner.nextLine(), formatter);

            double total = fundsTransferService.getTotalSentAmount(startDate, endDate);
            System.out.printf("Tổng số tiền đã chuyển từ %s đến %s: %.2f%n",
                    startDate.format(formatter), endDate.format(formatter), total);
        } catch (Exception e) {
            System.err.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy HH:mm:ss");
        }
    }

    private static void getTotalReceivedAmount(Scanner scanner) {
        System.out.println("Nhập ID tài khoản cần thống kê:");
        try {
            int accountId = Integer.parseInt(scanner.nextLine());
            double total = fundsTransferService.getTotalReceivedAmountByAccount(accountId);
            System.out.printf("Tổng số tiền nhận được của tài khoản %d: %.2f%n", accountId, total);
        } catch (NumberFormatException e) {
            System.err.println("ID tài khoản phải là số nguyên.");
        }
    }

    private static void getSuccessfulTransactionsCount(Scanner scanner) {
        try {
            System.out.println("Nhập ngày bắt đầu (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime startDate = LocalDateTime.parse(scanner.nextLine(), formatter);
            System.out.println("Nhập ngày kết thúc (dd/MM/yyyy HH:mm:ss):");
            LocalDateTime endDate = LocalDateTime.parse(scanner.nextLine(), formatter);

            int count = fundsTransferService.getSuccessfulTransactionsCount(startDate, endDate);
            System.out.printf("Số giao dịch thành công từ %s đến %s: %d%n",
                    startDate.format(formatter), endDate.format(formatter), count);
        } catch (Exception e) {
            System.err.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy HH:mm:ss");
        }
    }
}
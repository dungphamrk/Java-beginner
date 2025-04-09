package Ex3_4.service.account;


import Ex3_4.service.AppService;

public interface AccountService extends AppService {
    int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount);
}

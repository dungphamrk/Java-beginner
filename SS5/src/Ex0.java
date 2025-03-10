import java.util.Scanner;

public class Ex0 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choice=0;
        int currentIndex=0;
        int[] arr = new int[100];
        int sum=0;
        do{
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In ra các phần tử của mảng");
            System.out.println("3. Tính tổng các phần tử của mảng");
            System.out.println("4.In ra các phần tử chia hết cho 3 và tính tổng");
            System.out.println("5.In ra các phần tử là số nguyên tố và tính tổng");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn của bạn");
            choice = sc.nextInt();
            switch(choice ){
                case 1:
                    System.out.print("Nhập số phần tử của mảng: ");
                    int n = sc.nextInt();
                    if (n <= 0) {
                        System.out.println("Số phần tử phải lớn hơn 0.");
                        break;
                    }
                    System.out.println("Nhập các phần tử của mảng: ");
                    for (int i = 0; i < n; i++) {
                        arr[currentIndex] = sc.nextInt();
                        currentIndex++;
                    }
                    break;

                case 2:
                    if (arr == null || arr.length == 0) {
                        System.out.println("Mảng chưa được nhập. Vui lòng chọn 1 để nhập mảng.");
                    } else {

                        System.out.println("Các phần tử của mảng là:");
                        for (int value : arr) {
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (arr == null || arr.length == 0) {
                        System.out.println("Mảng chưa được nhập. Vui lòng chọn 1 để nhập mảng.");
                    } else {
                        sum = 0;
                        for (int value : arr) {
                            sum += value;
                        }
                        System.out.println("Tổng các phần tử của mảng là: " + sum);
                    }
                    break;
                case 4:
                    sum=0;
                    System.out.println("Các số chia hết cho 3 trong mảng đó là: ");
                    for (int i = 0; i < currentIndex ; i++) {
                        if(arr[i]%3==0){
                            System.out.println(arr[i]);
                            sum+=arr[i];
                        }
                    }
                    if (sum==0) {
                        System.out.println("Không có số nào trong mảng chia hết cho 3");
                    }else {
                        System.out.println("Tổng các số chia hết cho 3 là: " + sum);
                    }
                case 5:
                    sum=0;
                    System.out.println("Các số nguyên tố có trong mảng là");
                    for(int value: arr){
                        if(value<2)
                            continue;
                        boolean isPrime=true;
                        for (int i = 2; i <Math.sqrt(value) ; i++) {
                            if(value%i==0){
                                isPrime=false;
                                break;
                            }
                        }
                        if(isPrime){
                            System.out.println(value);
                        }
                    }
                    if (sum==0) {
                        System.out.println("Không có số nguyên tố nào tồn tại trong mảng");
                    }else {
                        System.out.println("Tổng các số nguyên tố đó là: " + sum);
                    }
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5};
        int max=arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là: "+max);
    }
}
